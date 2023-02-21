package domain.mediator;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

import domain.model.Message;
import domain.model.User;
/**
 * 
 * @author Daniel Borisov
 */
public class ClientModelProxy implements ModelClient, Observer
{

   private ObjectInputStream inFromServer;
   private ObjectOutputStream outToServer;
   private ModelClient model;
   private Socket socket;

   private static final String HOST = "localhost";
   private static final int PORT = 6759;

   /**
    * Creating new Socket and sending messages.
    * @param model
    * @throws IOException
    */
   public ClientModelProxy(ModelClient model) throws IOException
   {
      this.model = model;

      try
      {
         socket = new Socket(HOST, PORT);
         outToServer = new ObjectOutputStream(socket.getOutputStream());
         inFromServer = new ObjectInputStream(socket.getInputStream());
         ClientReceiver receiver = new ClientReceiver(inFromServer, model);
         new Thread(receiver, "Receiver").start();
      }
      catch (IOException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

   @Override
   public void addMessageInModel(Message message)
   {
      try
      {
         outToServer.writeObject(message);
      }
      catch (Exception e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      System.out.println("DEBUG: Proxy add: " + message);
   }

   @Override
   public void notifyAboutMessage(Message message)
   {
      // TODO Auto-generated method stub

   }

   @Override
   public void update(Observable arg0, Object arg1)
   {
      try
      {
         Message message = (Message) arg1;
         outToServer.writeObject(message);
      }
      catch (Exception e)
      {
         // no client connection
         System.out.println("DEBUG: Exception for client broadcast " + " - "
               + e.getMessage());
         ((Observable) model).deleteObserver(this);
         Message m = new Message(
               "DEBUG: Server> A client has been disconnected");
         System.out.println("DEBUG: " + m);
         model.addMessageInModel(m);
      }

   }

   @Override
   public void addMessage(Message message, String userAccount, int userId)
         throws Exception
   {
      // TODO Auto-generated method stub
      
   }


   @Override
   public boolean testUser(String userAccount, String userPassword)
         throws Exception
   {
      // TODO Auto-generated method stub
      return false;
   }

   @Override
   public boolean testAdmin(String adminAccount, String adminPassword)
         throws Exception
   {
      // TODO Auto-generated method stub
      return false;
   }

  

   @Override
   public int getIdForUserFromDatabase(String userAccount) throws Exception
   {
      // TODO Auto-generated method stub
      return 0;
   }

}