package utility.collection;

import java.io.Serializable;

public class MonthInterval implements Serializable
{
   private String month;
   
   public MonthInterval(String month)
   {
      this.month = month;
   }
   
   public String getMonth()
   {
      return month;
   }
   
   public String toString()
   {
      return month;
   }
}
