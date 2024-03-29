import akka.NotUsed;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.http.javadsl.ConnectHttp;
import akka.http.javadsl.Http;
import akka.http.javadsl.ServerBinding;
import akka.http.javadsl.marshallers.jackson.Jackson;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.http.javadsl.server.Route;
import akka.pattern.Patterns;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;
import scala.concurrent.Future;

import java.io.IOException;
import java.util.concurrent.CompletionStage;

import static akka.http.javadsl.server.Directives.*;


public class Lab4 {
    private ActorRef routerActor;

    public static void main(String[] args) throws IOException {
        ActorSystem system = ActorSystem.create("lab4");

        final Http http = Http.get(system);
        final ActorMaterializer materializer = ActorMaterializer.create(system);
        Lab4 instance = new Lab4();
        final Flow<HttpRequest, HttpResponse, NotUsed> routeFlow =
                instance.createRoute().flow(system, materializer);
        final CompletionStage<ServerBinding> binding = http.bindAndHandle(
                routeFlow,
                ConnectHttp.toHost("localhost", 8080),
                materializer
        );
        System.out.println("Server online at http://localhost:8080/\nPress RETURN to stop...");
        System.in.read();
        binding
                .thenCompose(ServerBinding::unbind)
                .thenAccept(unbound -> system.terminate());

    }


    private Route createRoute() {
        ActorSystem system = ActorSystem.create("lab4");
        routerActor = system.actorOf(Props.create(RouterActor.class));
        return concat(get(() ->
            parameter("packageId",Id ->{
            Future<Object> result = Patterns.ask(routerActor,new TestPackageMsg(Integer.parseInt(Id))
                    , 5000);
            return completeOKWithFuture(result, Jackson.marshaller());
        })),
                post(()-> entity(Jackson.unmarshaller(TestPackage.class), msg -> {
                    routerActor.tell(msg, ActorRef.noSender());
                    return complete("Test started!");
                })));
    }
}

