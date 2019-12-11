import akka.actor.AbstractActor;
import akka.actor.ActorRef;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.security.cert.CertPathBuilder;

public class TestActor extends AbstractActor{
    public TestActor(){

    }
    public AbstractActor.Receive createReceive() {
        return receiveBuilder()
                .match(TestMes.class, this :: resTest)
                .build();
    }

    public String doTest(TestMes test) throws ScriptException, NoSuchMethodException {
        try {
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
            engine.eval(test.getJsScript());
            Invocable invocable = (Invocable) engine;
            String res = invocable.invokeFunction(test.getFunction(), (Object) test.getTest().getParams()).toString();
        return res;
        }catch (Exception er){
            return er.toString();
        }
    }

    public void resTest(TestMes test) throws ScriptException, NoSuchMethodException {

        getSender().tell( new ResultMes(new ResultTest(test.getTest(),doTest(test)), test.getPackageID()), ActorRef.noSender());
    }
}
