package utility.model;

public class WinningCondition
{
   private String x1y1;
   private String x1y2;
   private String x1y3;
   private String x2y1;
   private String x2y2;
   private String x2y3;
   private String x3y1;
   private String x3y2;
   private String x3y3;
   
   public WinningCondition(String a, String b, String c, String d, String e, String f, String g, String h, String i)
   {
      x1y1 = a;
      x1y2 = b;
      x1y3 = c;
      x2y1 = d;
      x2y2 = e;
      x2y3 = f;
      x3y1 = g;
      x3y2 = h;
      x3y3 = i;
   }
   
   public boolean checkForWin()
   {
       if( (x1y1.equals(x1y2) && x1y2.equals(x1y3) && (!x1y1.equals(""))) || (x1y1.equals(x2y1) && x2y1.equals(x3y1) && (!x1y1.equals(""))) || (x1y1.equals(x2y2) && x2y2.equals(x3y3) && (!x1y1.equals(""))) || 
           (x1y2.equals(x2y2) && x2y2.equals(x3y2) && (!x1y2.equals(""))) || (x1y3.equals(x2y3) && x2y3.equals(x3y3) && (!x1y3.equals(""))) || (x2y1.equals(x2y2) && x2y2.equals(x2y3) && (!x2y1.equals(""))) ||
           (x3y1.equals(x3y2) && x3y2.equals(x3y3) && (!x3y1.equals(""))) || (x3y1.equals(x2y2) && x2y2.equals(x1y3)) && (!x3y1.equals("")))
      {
         return true;
      }
      else return false;
   }
} 
