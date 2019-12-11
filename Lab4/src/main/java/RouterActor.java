import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.routing.RoundRobinPool;

public class RouterActor extends AbstractActor{
    private ActorRef storeActor;
    private ActorRef testactor;

    public void RouterActor(){
        this.storeActor = getContext().actorOf(Props.create(StoreActor.class),"storeActor");
        this.testactor = getContext().actorOf(new RoundRobinPool(5).props(Props.create(TestActor.class)), "testActor");
    }
    public AbstractActor.Receive createReceive() {
        return receiveBuilder()
                .match(TestPackage.class , this :: runTest)
                .build();
    }
    public void getTest(){

    }
    private void runTest(TestPackage testPackage){
        for (Test test: testPackage.getTests()) {
            ResultTest
        }
    }
}
