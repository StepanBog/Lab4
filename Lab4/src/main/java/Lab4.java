import akka.*;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.http.javadsl.*;



public class Lab4 {
    public static void main(String[] args){
        ActorSystem system = ActorSystem.create("lab4");
        final Http http = Http.get(system);
        MainHttp instance = new MainHttp(system);
        ActorRef storeActor = system.actorOf(
                Props.create(StoreActor.class)
        );

    }
}
