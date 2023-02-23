package utility;

public class Counter
{
   private long value;
   private long max;
   private long min;
   
   public Counter(long min, long max)
   {
      value = 0;
      this.max = max;
      this.min = min;
   }
   
   public synchronized void increment() 
   {
      while(value>= max)
      {
         try
         {
            wait();
         }
         catch (InterruptedException e)
         {
           // e.printStackTrace();
         }
         //System.out.println(value + ": " + Thread.currentThread().getName() + " incrementer");
      }
      value++;
      System.out.println(value + ": " + Thread.currentThread().getName() + " incrementer");
      notifyAll();
      Thread.yield();
   }
   
   public synchronized void decrement() 
   {
     while(value<= min)
     {
         try
         {
            wait();
         }
         catch(InterruptedException e)
         {
            //
         }
         //System.out.println(value + ": " + Thread.currentThread().getName() + " decrementer");
     }
     value--;
     System.out.println(value + ": " + Thread.currentThread().getName() + " decrementer");
     notifyAll();
     Thread.yield();
   }
   
   public synchronized long getValue()
   {
      synchronized(this)
      {
      return value;
      }
   }
}
