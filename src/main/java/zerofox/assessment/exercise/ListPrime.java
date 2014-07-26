package zerofox.assessment.exercise;

import java.io.Console;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;

import zerofox.assessment.exercise.primes.*;

public class ListPrime {

	
    public static void main(String[] args) 
    {
        Console console = System.console();
        String input = console.readLine("Enter number: ");
        try
        {
    	    Integer n = new Integer(Integer.parseInt(input));
            (new ListPrime()).run(n);
        }
        catch (Exception e)
        {
            System.out.println("Sorry! incorrect input");
            System.exit(1);
        }
    }

    private void run(Integer n) 
    {    	
        ActorSystem system = ActorSystem.create("CalcSystem");
        
        for(int i=2;i<n;i++)    
        {
        	ActorRef worker = system.actorOf(PrimeWorker.createPrimeWorker(), "master"+i);
        	worker.tell(i, ActorRef.noSender());
        }
        
        system.shutdown();
    }
}
