import akka.actor.AbstractActor;

public class RouterActor {
    public AbstractActor.Receive createReceive() {
        return receiveBuilder()
                .build();
    }
}
