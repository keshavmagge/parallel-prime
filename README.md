parallel-prime
==============

parallel-prime is a java application to compute prime numbers less than n 
using distributed task-worker architecure using Akka toolkit 

About Akka
----------
Akka helps build distributed and concurrent application easily in Java (and Scala) 
visit http://akka.io/ for documentation

Development Process:

Install Maven
-------------

    brew install maven 


Install Akka
------------
Download akka from http://akka.io/downloads/ and install it at /path/to/akka-2.2.4/

    cd /path/to/akka-2.2.4/
    export AKKA_HOME=<pwd>
    
    
Creating Akka Maven Project
---------------------------

    mvn archetype:generate 
       -DgroupId=zerofox.assessment.exercise.prime 
       -DartifactId=zerofox-assessment-exercise-prime
       -DarchetypeArtifactId=maven-archetype-quickstart
       -DinteractiveMode=false

parallel-prime design
---------------------
Accepts an integer as input from the user. Creates and ActorSystem and workers within the ActorSystem
and sends them a message that has the integer to be checked for "isPrime". Each worker reads the 
message and prints out the integer in the message if it happens to be primr. The workers are reused 
with new messages each time.

Compile parallel prime
----------------------

    mvn clean install

Add jar files to CLASSPATH
--------------------------

    export CLASSPATH=/User/<user>/.m2

Execute project
---------------

    mvn exec:java -Dexec.mainClass="zerofox.assessment.exercise.ListPrime"


Sample Run
----------

    http://pastebin.com/PbTmeXw8 
