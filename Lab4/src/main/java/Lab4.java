import akka.*;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;



public class Lab4 {
    public static void main(String[] args){
        ActorSystem system = ActorSystem.create("lab4");
        final Http http = Http.get(system);
        ActorRef storeActor = system.actorOf(
                Props.create(StoreActor.class)
        );
    }
}
