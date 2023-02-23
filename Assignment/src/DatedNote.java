/*using Date class from question 2, it's basically extended version of what is asked in question1*/
public class DatedNote extends Note
{
   private Date date;
   
   public DatedNote(String message, Date date)
   {
      super(message);
      this.date = new Date(date.getDay(), date.getMonth(), date.getYear());
   }
   
   public Date getDate()
   {
      return date;
   }
   
   public Note copy()
   {
      return new DatedNote(getMessage(), date);
   }
   
   public String toString()
   {
      return super.toString() + "\nDate: " + date.toString();
   }
}
