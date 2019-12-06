import akka.actor.AbstractActor;

public class TestActor {
    public AbstractActor.Receive createReceive() {
        return receiveBuilder()
                .build();
    }
}
