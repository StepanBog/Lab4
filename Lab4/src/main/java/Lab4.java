import akka.*;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.*;




public class Lab4 {
    public static void main(String[] args){
        ActorSystem system = ActorSystem.create("lab4");
        final ActorMaterializer materializer = ActorMaterializer.create(system);
        MainHttp instance = new MainHttp(system);
        ActorRef storeActor = system.actorOf(
                Props.create(StoreActor.class)
        );

    }
}
