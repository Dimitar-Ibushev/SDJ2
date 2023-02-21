package domain.mediator;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import domain.model.Message;
import domain.model.User;
/**
 * 
 * @author Daniel Borisov
 *
 */
public interface Model
{
/**
 * Adding messages from Users into Database.
 * @param message
 * @param userAccount
 * @param userId
 * @throws Exception
 */
   void addMessage(Message message, String userAccount, int userId)
         throws Exception;
   
   /**
    * Adding messages from Administrators into Database.
    * @param message
    * @param adminAccount
    * @param adminId
    * @throws Exception
    */
   void addMessageAdmin(Message message, String adminAccount, int adminId)
         throws Exception;
   
   /**
    * Adding messages into list that holds objects.
    * @param message
    */
   void addMessageInModel(Message message);

   /**
    * Its notifying all clients for new massages.
    * @param message
    */
   void notifyAboutMessage(Message message);

   /**
    * With this method we are creating New User Account
    * @param userAccount
    * @param userPassword
    * @throws Exception
    */
   void createUser(String userAccount, String userPassword) throws Exception;

   /**
    * With this method we are creating New Administrator Account
    * @param adminAccount
    * @param adminPassword
    * @throws Exception
    */
   void createAdministrator(String adminAccount, String adminPassword)
         throws Exception;

   /**
    * With this method we are getting list that holds objects of messages. 
    * @return
    * @throws Exception
    */
   Message[] getAllMessagesFromModel() throws Exception;

   /**
    * Whit this method we are getting all messages from the Database.
    * @return
    * @throws Exception
    */
   ArrayList<String> getAllMessagesFromDatabase() throws Exception;

   /**With this method we are checking if the User credentials are correct
    * or if they exist. 
    * @param userAccount
    * @param userPassword
    * @return
    * @throws Exception
    */
   boolean testUser(String userAccount, String userPassword) throws Exception;

   /**With this method we are checking if the Administrator credentials are correct
    * or if they exist.  
    * @param adminAccount
    * @param adminPassword
    * @return
    * @throws Exception
    */
   boolean testAdmin(String adminAccount, String adminPassword)
         throws Exception;

   /**With this method we are getting all User from Database
    * @return
    * @throws Exception
    */
   ArrayList<String> getAllUsersFromDatabase() throws Exception;

   /**
    * With this method we are getting list that holds objects of Users. 
    * @return
    * @throws Exception
    */
   String[] getAllUsersFromModel() throws Exception;

   /**
    * With this method we are getting the password for all users.
    * @return
    * @throws Exception
    */
   ArrayList<String> getAllUserPasswords() throws Exception;

   /**
    * With this method we are getting all Administrators from Database.
    * @return
    * @throws Exception
    */
   ArrayList<String> getAllAdminsFromDatabase() throws Exception;

   /**
    * With this method we are getting list that holds objects of Administrators. 
    * @return
    * @throws Exception
    */
   String[] getAllAdminsFromModel() throws Exception;

   /**
    * With this method we are getting the passwords for all Administrators.
    * @return
    * @throws Exception
    */
   ArrayList<String> getAllAdminPasswords() throws Exception;

   /**
    * With this method we are modifying the credentials for User Account.
    * @param userAccount
    * @param userPassword
    * @param userId
    * @throws SQLException
    */
   void modifyUser(String userAccount, String userPassword, int userId)
         throws SQLException;

   /**
    * With this method we are modifying the credentials for Administrator Account.
    * @param adminAccount
    * @param adminPassword
    * @param adminId
    * @throws SQLException
    */
   void modifyAdmin(String adminAccount, String adminPassword, int adminId)
         throws SQLException;

   /**
    * With this method we are deleting User from Datebase
    * @param user
    * @throws Exception
    */
   void deleteUser(User user) throws Exception;

   /**
    * We are deleting certain message from the list that hold Object of all messages.
    * @param message
    * @throws Exception
    */
   void deleteMessageFromModel(Message message) throws Exception;

   /**
    * With this method we are deleting message from Database
    * @param userAccount
    * @throws Exception
    */
   void deleteMessageFromDatabase(String userAccount) throws Exception;

   /**
    * Getting messages for certain period from Database.
    * @param a
    * @param b
    * @return
    * @throws Exception
    */
   ArrayList<String> getMessagesForPeriodFromDatabase(Date a, Date b)
         throws Exception;
   
   /**
    * Getting Id for User Account from Database.
    * @param userAccount
    * @return
    * @throws Exception
    */
   int getIdForUserFromDatabase(String userAccount) throws Exception;
   
   /**
    * Getting Id for Administrator Account from Database.
    * @param ussernameFromLogIn
    * @return
    * @throws Exception
    */
   int getIdForAdminFromDatabase(String ussernameFromLogIn) throws Exception;

}