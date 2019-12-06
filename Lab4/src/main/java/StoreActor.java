import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class StoreActor extends AbstractActor {
    private  Map<Integer, List<ResultTest>> storage = new HashMap<>();

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(R)
                .build();
    }

    public void getResult(ResultMes res){
        List<ResultTest> list = new ArrayList<>();
        list.add(res.getResTest());
        storage.put(res.getPackegeID(),list);
    }
    public void goTest(TestMes test){
        sender().tell();
    }
}