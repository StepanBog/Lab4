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
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(test.getJsScript());
        Invocable invocable = (Invocable) engine;
        return invocable.invokeFunction(test.getFunction(), test.getTest().getParams()).toString();
    }

    public void resTest(TestMes test) throws ScriptException, NoSuchMethodException {
        String res = doTest(test);
        getSender().tell( new ResultMes(new ResultTest(test.getTest(),res), test.getPackageID()), ActorRef.noSender());
    }
}
