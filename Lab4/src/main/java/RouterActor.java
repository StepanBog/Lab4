import akka.actor.AbstractActor;
import akka.actor.ActorRef;

public class RouterActor extends AbstractActor{
    private ActorRef storeActor;
    private ActorRef testactor;
    public AbstractActor.Receive createReceive() {
        return receiveBuilder()
                .build();
    }
}
