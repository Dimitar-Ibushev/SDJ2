package utility;

public class CounterDecrementer implements Runnable
{
   private int updates;
   private Counter counter;
   
   public CounterDecrementer(Counter counter, int updates)
   {
      this.counter = counter;
      this.updates = updates;
   }
   @Override
   public  void run()
   {
      while(updates > 0)
      {
         counter.decrement();
         System.out.println("Decrement updates: " + updates + "Value: " + counter.getValue());
         updates--;
      }

   }

}
