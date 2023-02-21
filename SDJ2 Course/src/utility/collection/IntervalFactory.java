package utility.collection;

import java.util.HashMap;

public class IntervalFactory
{
   private static HashMap<String, DesiredInterval> intervals = new HashMap<String, DesiredInterval>();
   
   public static DesiredInterval getInterval(String month)
   {
      DesiredInterval item = intervals.get(month);
      
      if(item == null)
      {
         item = new DesiredInterval(month);
         intervals.put(month, item);
      }
      
      return item;
   }
}
