package domain.mediator;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;

import domain.model.Administrator;
import domain.model.AdministratorList;
import domain.model.Message;
import domain.model.MessageList;
import domain.model.User;
import domain.model.UserList;
/**
 * 
 * @author Daniel Borisov
 *
 */
public class ClientModelManager extends Observable implements ModelClient
{
   private ClientModelProxy proxy;
   private DatabaseInterface database;

   /**
    * 
    * @throws SQLException
    */
   public ClientModelManager() throws SQLException
   {
      this.database = new ChatDatabase();
      try
      {
         proxy = new ClientModelProxy(this);
      }
      catch (IOException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

   @Override
   public void addMessage(Message message, String userAccount, int userId)
         throws Exception
   {

      database.insertIntoMessages(message, userAccount, userId);
   }

   public void addMessageInModel(Message message)
   {
      proxy.addMessageInModel(message);
   }

   @Override
   public void notifyAboutMessage(Message message)
   {
      super.setChanged();
      super.notifyObservers(message);

   }

   @Override
   public boolean testUser(String userAccount, String userPassword)
         throws Exception
   {
      return database.testUser(userAccount, userPassword);

   }

   @Override
   public boolean testAdmin(String adminAccount, String adminPassword)
         throws Exception
   {
      return database.testAdmin(adminAccount, adminPassword);
   }

   @Override
   public int getIdForUserFromDatabase(String userAccount) throws Exception
   {
      return database.getIdForUser(userAccount);
   }

}