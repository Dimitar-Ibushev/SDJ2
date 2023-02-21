package utility.collection;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DesiredInterval implements Serializable
{
   private String month;
   private MonthInterval interval;

   public DesiredInterval(String month)
   {
      this.month = month;
      interval = new MonthInterval(month);
   }
   
   public String getMonth()
   {
      return interval.getMonth();
   }
   
   public int getMonthNumber()
   {
      int needed = 0;
     switch(interval.getMonth().toLowerCase())
     {
        case "january": needed = 1;
        break;
        
        case "february": needed = 2;
        break;
        
        case "march": needed = 3;
        break;
        
        case "april": needed = 4;
        break;
        
        case "may": needed = 5;
        break;
        
        case "june": needed = 6;
        break;
        
        case "july": needed = 7;
        break;
        
        case "august": needed = 8;
        break;
        
        case "september": needed = 9;
        break;
        
        case "october": needed = 10;
        break;
        
        case "december": needed = 12;
        break;
        
        default: needed = 0;
        break;
     }
     return needed;
   }
   
   
   public String toString()
   {
      return getMonth() + " (" + getMonthNumber() + ") ";
   }
}
