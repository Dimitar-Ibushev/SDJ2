package utility;

public class CounterIncrementer implements Runnable
{
   private int updates;
   private Counter counter;
   
   public CounterIncrementer(Counter counter, int updates)
   {
      this.counter = counter;
      this.updates = updates;
   }
   @Override
   public  void run()
   {
      while(updates > 0)
      {
         counter.increment();
         System.out.println("Increment updates: " + updates + "Value: " + counter.getValue());
         updates--;
      }

   }

}
