package zerofox.assessment.exercise;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;

import zerofox.assessment.exercise.primes.*;

public class ListPrime {

	
    public static void main(String[] args) {
    	Integer n = new Integer(100);
        new PrimeWorker().run(n);
    }

    private void run(Integer n) {
    	
        ActorSystem system = ActorSystem.create("CalcSystem");
        
        for(int i=2;i<n;i++) {
        	ActorRef worker = system.actorOf(PrimeWorker.createMaster(), "master"+i);
        	worker.tell(i, ActorRef.noSender());
        }
        
        system.shutdown();
    }
}
