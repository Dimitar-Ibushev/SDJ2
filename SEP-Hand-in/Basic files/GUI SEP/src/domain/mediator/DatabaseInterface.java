package domain.mediator;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import domain.model.Message;
/**
 * 
 * @author Daniel Borisov
 *
 */
public interface DatabaseInterface
{
	
	/**This method is for creating new User Account.
	 * @param userAccount
	 * @param userPassword
	 * @throws SQLException
	 */
   void insertIntoUser(String userAccount, String userPassword)
         throws SQLException;
   
   /** Creating Administrator Account.
    * @param adminAccount
    * @param adminPassword
    * @throws SQLException
    */
   void insertIntoAdministrator(String adminAccount, String adminPassword)
         throws SQLException;
   
   /**This method is returning List of all messages from User Accounts
    *  from Database 
    * @return
    * @throws Exception
    */
   ArrayList<String> getAllMessagesFromUsers() throws Exception;
   
   /**This method is returning massages for a certain period of time.
    * @param a
    * @param b
    * @return
    * @throws SQLException
    */
   ArrayList<String> getMessagesFromUsers(Date a, Date b)
        throws SQLException;
   
   /**Inserting messages from Administrators
    * @param message
    * @param adminAccount
    * @param adminId
    * @throws Exception
    */
   void insertIntoMessagesAdmin(Message message, String adminAccount,
         int adminId) throws Exception;
   
   /**
    * Inserting messages into Database from users.
    * @param message
    * @param userAccount
    * @param userId
    * @throws Exception
    */
   void insertIntoMessages(Message message,String userAccount, int userId) throws Exception;
   String getUser(int userId) throws SQLException;

   /**With this method we are checking if the User credentials are correct
    * or if they exist.
    * @param userAccount
    * @param userPassword
    * @return
    * @throws Exception
    */
   boolean testUser(String userAccount, String userPassword)
         throws Exception;
   
   /**
    * With this method we are checking if the Administrator credentials are correct
    * or if they exist.
    * @param adminAccount
    * @param adminPassword
    * @return
    * @throws Exception
    */
   boolean testAdmin(String adminAccount, String adminPassword)
         throws Exception;
   /**
    * This method is giving us all User Accounts.
    * @return
    * @throws Exception
    */
   ArrayList<String> getAllUsers() throws Exception;
   
   /**
    * This method is returning Passwords for all User Accounts.
    * @return
    * @throws Exception
    */
   ArrayList<String> getAllUserPasswords() throws Exception;
   
   /**
    * This method is giving us all Administrator Accounts.
    * @return
    * @throws Exception
    */
   ArrayList<String> getAllAdmins() throws Exception;
   
   /**
    * This method is returning all password for Administrator Accounts.
    * @return
    * @throws Exception
    */
   ArrayList<String> getAllAdminPasswords() throws Exception;
   
   /**
    * With this method we are modifying User Credentials.
    * @param userAccount
    * @param userPassword
    * @param userId
    * @throws SQLException
    */
   void modifyUser(String userAccount, String userPassword, int userId)
         throws SQLException;
   
   /**
    * With this method we are modifying Administrator credentials.
    * @param adminAccount
    * @param adminPassword
    * @param adminId
    * @throws SQLException
    */
   void modifyAdmin(String adminAccount, String adminPassword,
         int adminId) throws SQLException;
   
   /**
    * This method is deleting User account from Database.
    * @param userAccount
    * @throws Exception
    */
    void deleteFromUser(String userAccount) throws Exception;
    
    /**
     * This method is deleting message from the Database.
     * @param userAccount
     * @throws Exception
     */
   void deleteFromMessage(String userAccount) throws Exception;
   
   /**
    * This method is deleting Administrator account from Database.
    * @param userAccount
    * @throws Exception
    */
    void deleteFromAdmin(String userAccount) throws Exception;
    
    /**
     * This method is returning the Id number of the User Account.
     * @param userAccount
     * @return
     * @throws Exception
     */
    int getIdForUser(String userAccount) throws Exception;
    
    /**
     * This method is getting the ID number for a certain Administrator 
     * @param adminAccount
     * @return
     * @throws Exception
     */
   int getIdForAdmin(String adminAccount) throws Exception;
}