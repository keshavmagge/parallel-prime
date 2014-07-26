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
            if(isPrime((Integer) message))  {
                System.out.println((Integer) message);
            }
        } else {
            unhandled(message);
        }
    }
    
   // check if number is prime. returns a bool
   private boolean isPrime(int n) {
	   if(n == 2) return true;
        // is n a multiple of 2?
        if (n%2 == 0) return false;
        // if not, check the odds
        for(int i=3; i*i<=n; i+=2) {
            if(n%i == 0)
                return false;
        }
        return true;
    }

    public static Props createPrimeWorker() {
        return Props.create(PrimeWorker.class, new ArraySeq<Object>(0));
    }
}
