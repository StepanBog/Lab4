import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class StoreActor extends AbstractActor {
    private  Map<Integer, List<String>> storage = new HashMap<>();

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match()
                .build();
    }

    public void getResult(ResultMes res){
        storage.put()
    }
    public void goTest(TestMes test){

    }
}