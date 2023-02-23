package test;

import utility.Counter;
import utility.CounterDecrementer;
import utility.CounterIncrementer;

public class Run
{
   public static void main(String[] args)
   {
      Counter counter = new Counter(0, 200);
      CounterIncrementer inc1 = new CounterIncrementer(counter ,200);
      CounterDecrementer dec1 = new CounterDecrementer(counter ,200);
      CounterIncrementer inc2 = new CounterIncrementer(counter ,200);
      CounterDecrementer dec2 = new CounterDecrementer(counter ,200);
      
      Thread incrementer1 = new Thread(inc1);
      Thread decrementer1 = new Thread(dec1);
      Thread incrementer2 = new Thread(inc2);
      Thread decrementer2 = new Thread(dec2);
      
      incrementer1.start();
      incrementer2.start();
      decrementer1.start();
      decrementer2.start();
   }
}
