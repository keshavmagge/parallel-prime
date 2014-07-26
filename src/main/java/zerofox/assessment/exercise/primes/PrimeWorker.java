package zerofox.assessment.exercise.primes;

import scala.collection.mutable.ArraySeq;
import akka.actor.Props;
import akka.actor.UntypedActor;

public class PrimeWorker extends UntypedActor {

    public PrimeWorker() {
    }
    
    @Override
    public void onReceive(Object message) {
        if (message instanceof Integer) {
        	System.out.println("In "+Thread.currentThread());
            if(isPrime((Integer) message)) {
            	System.out.print(message+", ");
            }
        } else {
            unhandled(message);
        }
    }
    
  //checks whether an int is prime or not.
   private boolean isPrime(int n) {
	   if(n==2) return true;
        //check if n is a multiple of 2
        if (n%2==0) return false;
        //if not, then just check the odds
        for(int i=3;i*i<=n;i+=2) {
            if(n%i==0)
                return false;
        }
        return true;
    }

    public static Props createPrimeWorker() {
        return Props.create(PrimeWorker.class, new ArraySeq<Object>(0));
    }
}
