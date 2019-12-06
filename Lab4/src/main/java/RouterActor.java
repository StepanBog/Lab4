import akka.actor.AbstractActor;

public class RouterActor extends AbstractActor{
    public AbstractActor.Receive createReceive() {
        return receiveBuilder()
                .build();
    }
}
