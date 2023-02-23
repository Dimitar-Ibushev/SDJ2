
public abstract class Note
{
   private String message;
   
   public Note(String message)
   {
      this.message = message;
   }
   
   public String getMessage()
   {
      return message;
   }
   
   public abstract Note copy();
   
   //consist of a single String, so getting that is sufficient
   public String toString()
   {
      return "\n" + getMessage();
   }
}
