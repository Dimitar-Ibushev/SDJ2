package domain.mediator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;

import domain.model.Administrator;
import domain.model.AdministratorList;
import domain.model.Message;
import domain.model.MessageList;
import domain.model.RoomList;
import domain.model.User;
import domain.model.UserList;
/**
 * 
 * @author Daniel Borisov
 *
 */
public class ServerModelManager extends Observable implements Model
{
   private MessageList list;
   private ServerConnection server;
   private User user;
   private Administrator admin;
   private UserList userList;
   private AdministratorList adminList;
   private DatabaseInterface database;

   /**
    * 
    * @throws SQLException
    */
   public ServerModelManager() throws SQLException
   {
      this.database = new ChatDatabase();
      this.list = new MessageList();
      this.userList = new UserList();
      this.adminList = new AdministratorList();
      this.server = new ServerConnection(this);
      new Thread(server, "Server").start();
   }
   /**
    * @Override
    */
   public void addMessage(Message message, String userAccount, int userId)
         throws Exception
   {

      database.insertIntoMessages(message, userAccount,
           userId);

   }
   /**
    *  @Override
    */
   public void addMessageAdmin(Message message, String adminAccount, int adminId)
         throws Exception
   {
      database.insertIntoMessagesAdmin(message, adminAccount, adminId);

   }
   /**
    * @Override
    */
   public void addMessageInModel(Message message)
   {
      list.addMessage(message);
      notifyAboutMessage(message);
      System.out.println("SERVERMODEL");
   }
/**
 *  @Override
 */
   public void notifyAboutMessage(Message message)
   {
      super.setChanged();
      super.notifyObservers(message);

   }
   /**
   * @Override
   */
   public void createUser(String userAccount, String userPassword)
         throws Exception
   {
      User u = new User(userAccount, userPassword);
      userList.addUser(u);
      database.insertIntoUser(userAccount, userPassword);
   }
  /**
  * @Override
  */
   public void createAdministrator(String adminAccount, String adminPassword)
         throws Exception
   {
      Administrator a = new Administrator(adminAccount, adminPassword);
      adminList.addAdmin(a);
      database.insertIntoAdministrator(adminAccount, adminPassword);
   }
   /**
   *@Override
   */
   public Message[] getAllMessagesFromModel() throws Exception
   {

      return list.getAll();
   }
   
   /**
    *@Override
   */
   public ArrayList<String> getAllMessagesFromDatabase() throws Exception
   {
      return database.getAllMessagesFromUsers();
   }
   /**
    *@Override
    */
   public ArrayList<String> getMessagesForPeriodFromDatabase(Date a, Date b)
         throws Exception
   {
      return database.getMessagesFromUsers(a, b);
   }
   /**
   * @Override
   */
   public boolean testUser(String userAccount, String userPassword)
         throws Exception
   {
	   if(database.testUser(userAccount, userPassword)== true)
	   {
	   User u = new User(userAccount, userPassword);
	      userList.addUser(u);
	   }
      return database.testUser(userAccount, userPassword);

   }

   /**
    * @Override
    */  
   public boolean testAdmin(String adminAccount, String adminPassword)
         throws Exception
   {
	   if(database.testAdmin(adminAccount, adminPassword) == true)
	   {
	   Administrator a = new Administrator(adminAccount, adminPassword);
	      adminList.addAdmin(a);
	   }
      return database.testAdmin(adminAccount, adminPassword);
   }

   /**
    *@Override
    */
   public ArrayList<String> getAllUsersFromDatabase() throws Exception
   {
      return database.getAllUsers();
   }

   /**
    *@Override
    */
   public String[] getAllUsersFromModel() throws Exception
   {

      return userList.getAllUsernames();

   }

   /**
    *@Override
    */
   public ArrayList<String> getAllUserPasswords() throws Exception
   {
      return database.getAllUserPasswords();
   }

   /**
    *@Override
    */
   public String[] getAllAdminsFromModel() throws Exception
   {
      return adminList.getAllUsernames();
   }
   
   /**
    *@Override
    */
   public ArrayList<String> getAllAdminsFromDatabase() throws Exception
   {
      return database.getAllAdmins();
   }

   /**
    *@Override
    */
   public ArrayList<String> getAllAdminPasswords() throws Exception
   {
      return database.getAllAdminPasswords();
   }

   /**
    *@Override
    */
   public void modifyUser(String userAccount, String userPassword, int userId)
         throws SQLException
   {
      user.setUser(userAccount, userPassword, userId);
      database.modifyUser(userAccount, userPassword, userId);

   }

   /**
    *@Override
    */
   public void modifyAdmin(String adminAccount, String adminPassword,
         int adminId) throws SQLException
   {
      admin.setAdministrator(adminAccount, adminPassword, adminId);
      database.modifyAdmin(adminAccount, adminPassword, adminId);
   }
   /**
    *@Override
    */
   public void deleteUser(User user) throws Exception
   {
      userList.removeUser(user);
      database.deleteFromUser(user.getUserName());
   }
   
   /**
    *@Override
    */
   public void deleteMessageFromModel(Message message) throws Exception
   {
      list.removeMessage(message);
   }
   
   /**
    *@Override
    */
   public void deleteMessageFromDatabase(String userAccount) throws Exception
   {
      database.deleteFromMessage(userAccount);
   }

   /**
    *@Override
    */
   public int getIdForUserFromDatabase(String userAccount) throws Exception
   {
      return database.getIdForUser(userAccount);
   }

   /**
    *@Override
    */
   public int getIdForAdminFromDatabase(String adminAccount) throws Exception
   {
      return database.getIdForAdmin(adminAccount);
   }
}