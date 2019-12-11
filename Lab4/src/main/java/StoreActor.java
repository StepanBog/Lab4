import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.japi.pf.ReceiveBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class StoreActor extends AbstractActor {
    private  Map<Integer, List<ResultTest>> storage = new HashMap<>();
    
    public StoreActor(){

    }
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(ResultMes.class,this::inputResult)
                .match(TestPackageMsg.class, this :: getResult)
                .build();
    }

    public void inputResult(ResultMes res){
        if (storage.containsKey(res.getPackageID())) {
            List<ResultTest> list = storage.get(res.getPackageID());
            list.add(res.getResTest());
        }
        else {
            List<ResultTest> list = new ArrayList<>();
            list.add(res.getResTest());
            storage.put(res.getPackageID(), list);
        }
    }
    public void getResult(TestPackageMsg testPackageMsg){
       getSender().tell(new TestAnswer(testPackageMsg.getPackageID(), storage.get(testPackageMsg.getPackageID())), ActorRef.noSender());
    }
}