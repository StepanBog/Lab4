import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class StoreActor extends AbstractActor {
    private  Map<Integer, List<ResultMes>> storage = new HashMap<>();

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(ResultMes.class,this::inputResult)
                .match(TestMes.class,this::goTest)
                .build();
    }

    public void inputResult(ResultMes res){
        if (storage.containsKey(res.getPackageID())) {
            List<ResultMes> list = storage.get(res.getPackageID());

        }
        else {
            List<ResultTest> list = new ArrayList<>();
            list.add(res.getResTest());
            storage.put(res.getPackageID(), list);
        }
    }
    public void goTest(TestMes test){
        sender().tell();
    }
}