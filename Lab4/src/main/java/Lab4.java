import akka.*;
import akka.actor.Props;

public class Lab4 {
    public static void main(String[] args){
        Props props1 = Props.create(StoreActor.class);
    }
}
