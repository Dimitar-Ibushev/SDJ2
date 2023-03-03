import java.io.Serializable;


public class Message implements Serializable
{
   private int id;
   private String messageBody;
   
   public Message(int id, String messageBody)
   {
      this.setId(id);
      this.messageBody = messageBody;
      if(messageBody == null)
      {
         this.messageBody = "";
      }
   }
   
   public Message(String message)
   {
      int i = (int) (messageBody.hashCode() * Math.random());
      setId(i);
      messageBody = message;
   }

   public int getId()
   {
      return id;
   }

   public void setId(int id)
   {
      this.id = id;
   }
   
   public String getBody()
   {
      return messageBody;
   }
   
   public String toString()
   {
      return "id= " + id + ", \"" + messageBody + "\"";
   }
}
