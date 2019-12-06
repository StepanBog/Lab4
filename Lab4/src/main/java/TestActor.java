import akka.actor.AbstractActor;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.security.cert.CertPathBuilder;

public class TestActor extends AbstractActor{
    public AbstractActor.Receive createReceive() {
        return receiveBuilder()
                .build();
    }
    public void doTest(TestMes test) throws ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(test.getJsScript());
        Invocable invocable = (Invocable) engine;
        return invocable.invokeFunction(test.getFunction(), test.getTest().getParams()).toString();
    }
}
