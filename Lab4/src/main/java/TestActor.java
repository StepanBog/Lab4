import akka.actor.AbstractActor;

import java.security.cert.CertPathBuilder;

public class TestActor extends AbstractActor{
    public AbstractActor.Receive createReceive() {
        return receiveBuilder()
                .build();
    }
    public void doTest(Test test){
        
    }
}
