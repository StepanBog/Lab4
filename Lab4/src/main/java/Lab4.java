import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.http.javadsl.Http;
im




public class Lab4 {
    public static void main(String[] args){
        ActorSystem system = ActorSystem.create("lab4");
        
        ActorRef storeActor = system.actorOf(
                Props.create(StoreActor.class)
        );

    }
}
