import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

public class RouterActor extends AbstractActor{
    private ActorRef storeActor;
    private ActorRef testactor;

    public void RouterActor(){
        this.storeActor = getContext().actorOf(Props.create(StoreActor.class))
    }
    public AbstractActor.Receive createReceive() {
        return receiveBuilder()
                .build();
    }
}
