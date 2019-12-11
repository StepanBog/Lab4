import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.routing.RoundRobinPool;

public class RouterActor extends AbstractActor{
    private ActorRef storeActor;
    private ActorRef testActors;

    public void RouterActor(){
        this.storeActor = getContext().actorOf(Props.create(StoreActor.class),"storeActor");
        this.testActors = getContext().actorOf(new RoundRobinPool(5).props(Props.create(TestActor.class)), "testActors");
    }
    public AbstractActor.Receive createReceive() {
        return receiveBuilder()
                .match(TestPackage.class , this :: runTest)
                .match(TestPackageMsg.class, this :: getTest)
                .build();
    }
    public void getTest(TestPackageMsg message){
     this.storeActor.tell(message,getSender());

    }
    private void runTest(TestPackage testPackage){
        for (Test test: testPackage.getTests()) {
            TestMes message = new TestMes (testPackage.getPackageID(),testPackage.getFuncName(),testPackage.getJsScript(), test);
            this.testActors.tell(message, storeActor);
        }
    }
}
