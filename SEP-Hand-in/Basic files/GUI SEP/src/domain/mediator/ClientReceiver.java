package domain.mediator;

import java.io.ObjectInputStream;

import domain.model.Message;
/**
 * 
 * @author Daniel Borisov
 *
 */
public class ClientReceiver implements Runnable
{
   private ObjectInputStream inFromServer;
   private ModelClient model;

   /**
    * 
    * @param inFromServer
    * @param model
    */
   public ClientReceiver(ObjectInputStream inFromServer, ModelClient model)
   {
      this.inFromServer=inFromServer;
      this.model=model;
   }
   @Override
   public void run()
   {
    try{
       while(true)
       {
          Message message=(Message) inFromServer.readObject();
          System.out.println("Receiver: " +message);
          model.notifyAboutMessage(message);
       }
    }
    catch(Exception e)
    {
       e.printStackTrace();
    }
      
   }
   
}
