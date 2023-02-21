package domain.mediator;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class ChatDatabase implements DatabaseInterface
{
   private static Driver driver;
   private final String url = "jdbc:postgresql://localhost:5432/postgres";
   private final String username = "postgres";
   private final String password = "bob";
   private Connection connection;

   /**
    * Create connection to the Database
    * @throws SQLException
    */
   public ChatDatabase() throws SQLException
   {
      driver = new org.postgresql.Driver();
      DriverManager.registerDriver(driver);
      this.connection = DriverManager.getConnection(url, username, password);

   }
   /** This method is deleting message from the Database.
    * @param userAccount 
    * @throws SQLException 
    */
   public void deleteFromMessage(String userAccount) throws Exception
   {
      String deleteStatement = "DELETE FROM \"SEP DBS\".messages WHERE user_account = ?";
      PreparedStatement statement = this.connection
            .prepareStatement(deleteStatement);
      statement.setString(1, userAccount);
      statement.executeUpdate();
      
   }

  /**This method is deleting User account from Database.
   * @param userAccount
   * @throws Exception
   */
   public void deleteFromUser(String userAccount) throws Exception
   {
      deleteFromMessage(userAccount);
      String deleteStatement = "DELETE FROM \"SEP DBS\".users WHERE user_account = ?";
      PreparedStatement statement = connection
            .prepareStatement(deleteStatement);
      statement.setString(1, userAccount);
      statement.executeUpdate();
   }

   /**This method is deleting Administrator account from Database. 
    * @param userAccount -
    * @throws Exception
    */
   public void deleteFromAdmin(String userAccount) throws Exception
   {
      Connection connection = DriverManager.getConnection(url, username,
            password);
      deleteFromMessage(userAccount);
      String deleteStatement = "DELETE FROM \"SEP DBS\".administrator WHERE admin_account = ?";
      PreparedStatement statement = connection
            .prepareStatement(deleteStatement);
      statement.setString(1, userAccount);
      statement.executeUpdate();
   }

   /**This method is for creating new User Account.
    * @param userAccount
    * @param userPassword
    * @throws SQLException
    */
   public void insertIntoUser(String userAccount, String userPassword)
         throws SQLException
   {
      String insertStatement = "INSERT INTO \"SEP DBS\".users (user_account, user_password) VALUES (?,?)";
      PreparedStatement statement = connection
            .prepareStatement(insertStatement);
      statement.setString(1, userAccount);
      statement.setString(2, userPassword);
      statement.executeUpdate();
      System.out.println("Record inserted");

   }
   
/**Creating Administrator Account.
 * @param adminAccount
 * @param adminPassword
 * @throws SQLException
 */
   public void insertIntoAdministrator(String adminAccount, String adminPassword)
         throws SQLException
   {
      String insertStatement = "INSERT INTO \"SEP DBS\".administrator (admin_account, admin_password) VALUES (?,?)";
      PreparedStatement statement = connection
            .prepareStatement(insertStatement);
      statement.setString(1, adminAccount);
      statement.setString(2, adminPassword);
      statement.executeUpdate();
      System.out.println("Record inserted");
   }
/** Inserting messages into Database from users.
 * @param message
 * @param userAccount
 * @param userId
 * @throws Exception
 */
   public void insertIntoMessages(Message message, String userAccount,
         int userId) throws Exception
   {
      String insertStatement = "INSERT INTO \"SEP DBS\".messages (message, user_account, user_id) VALUES(?,?,?)";
      PreparedStatement statement = connection
            .prepareStatement(insertStatement);
      statement.setString(1, message.getBody());
      statement.setString(2, userAccount);
      statement.setInt(3, userId);
      statement.executeUpdate();
      System.out.println("Record inserted");
   }

   /**This method is getting the ID number for a certain Administrator 
    * account.
    * @param adminAccount
    * @throws Exception
    */
   public int getIdForAdmin(String adminAccount) throws Exception
   {
      String statement = "SELECT admin_id FROM \"SEP DBS\".administrator WHERE admin_account=?";
      PreparedStatement selectStatement = connection
            .prepareStatement(statement);
      selectStatement.setString(1, adminAccount);
      ResultSet rs = selectStatement.executeQuery();

      while (rs.next())
      {
         return rs.getInt("admin_id");

      }
      return -1;

   }
   
/**Inserting messages from Administrators
 * @param message
 * @param adminAccount
 * @param adminId
 * @throws Exception
 */
   public void insertIntoMessagesAdmin(Message message, String adminAccount,
         int adminId) throws Exception
   {
      String insertStatement = "INSERT INTO \"SEP DBS\".messages (message, admin_account, admin_id) VALUES(?,?,?)";
      PreparedStatement statement = connection
            .prepareStatement(insertStatement);
      statement.setString(1, message.getBody());
      statement.setString(2, adminAccount);
      statement.setInt(3, adminId);
      statement.executeUpdate();
      System.out.println("Record inserted");
   }

   /**This method is returning List of all messages from User Accounts
    *  from Database 
    * @return list -returning List of all messages 
    * @throws Exception
    */
   public ArrayList<String> getAllMessagesFromUsers() throws Exception
   {
      ArrayList<String> list = new ArrayList<>();
      String statement = "SELECT message, user_account, send_at FROM \"SEP DBS\".messages";
      PreparedStatement selectStatement = connection
            .prepareStatement(statement);
      ResultSet rs = selectStatement.executeQuery();
      while (rs.next())
      {
         System.out.println("User sending the message: "
               + rs.getString("user_account"));
         System.out.println("message send: " + rs.getString("message") + ", ");
         System.out.println("time of sending: " + rs.getObject("send_at"));
         list.add(rs.getString("user_account").replaceAll("\\s+", "") + ", "
               + rs.getString("message") + ", " + rs.getObject("send_at")
               + "\n");

      }
      System.out.println(list);
      return list;
   }

   /**This method is returning massages for a certain period of time.
    * @param a
    * @param b
    * @return list - returning list of all messages
    * @throws SQLException
    */
   public ArrayList<String> getMessagesFromUsers(Date a, Date b)
         throws SQLException
   {
      ArrayList<String> list = new ArrayList<>();
      
      String statement = "SELECT message, user_account, send_at FROM \"SEP DBS\".messages";
      PreparedStatement selectStatement = connection
            .prepareStatement(statement);
      ResultSet rs = selectStatement.executeQuery();
      while (rs.next() && rs.getDate("send_at").compareTo(a) >= 0
            && rs.getDate("send_at").compareTo(b) <= 0)
      {
         System.out.println("User sending the message: "
               + rs.getString("user_account"));
         System.out.println("message send: " + rs.getString("message") + ", ");
         System.out.println("time of sending: " + rs.getObject("send_at"));
         list.add(rs.getString("user_account").replaceAll("\\s+", "") + ", "
               + rs.getString("message") + ", " + rs.getObject("send_at")
               + "\n");

      }

      System.out.println("List ot databaza : " + list);
      return list;
   }

   /**With this method we are checking if the User credentials are correct
    * or if they exist.
    * @param userAccount
    * @param userPassword
    * @return correct - returning if the user credentials are correct.
    * @throws Exception
    */
   public boolean testUser(String userAccount, String userPassword)
         throws Exception
   {
      boolean correct = false;
      String statement = "SELECT user_account,user_password FROM \"SEP DBS\".users";
      PreparedStatement selectStatement = connection
            .prepareStatement(statement);
      ResultSet rs = selectStatement.executeQuery();
      while (rs.next())
      {
         if (rs.getString("user_account").replaceAll("\\s+", "")
               .equals(userAccount)
               && rs.getString("user_password").replaceAll("\\s+", "")
                     .equals(userPassword))
         {
            correct = true;
            return correct;
         }

      }
      return correct;
   }
/**With this method we are checking if the Administrator credentials are correct
 * or if they exist.
 * @param adminAccount
 * @param adminPassword
 * @return correct - returning if the Admin credentials are correct.
 * @throws Exception
 */
   public boolean testAdmin(String adminAccount, String adminPassword)
         throws Exception
   {
      boolean correct = false;
      String statement = "SELECT admin_account,admin_password FROM \"SEP DBS\".administrator";
      PreparedStatement selectStatement = connection
            .prepareStatement(statement);
      ResultSet rs = selectStatement.executeQuery();
      while (rs.next())
      {
         if (rs.getString("admin_account").replaceAll("\\s+", "")
               .equals(adminAccount)
               && rs.getString("admin_password").replaceAll("\\s+", "")
                     .equals(adminPassword))
         {
            correct = true;
            return correct;
         }

      }
      return correct;
   }
/**This method is giving us all User Accounts.
 * @return list - returning list of users
 * @throws Exception
 */
   public ArrayList<String> getAllUsers() throws Exception
   {
      ArrayList<String> list = new ArrayList<>();
      String statement = "SELECT user_account FROM \"SEP DBS\".users";
      PreparedStatement selectStatement = connection
            .prepareStatement(statement);
      ResultSet rs = selectStatement.executeQuery();
      while (rs.next())
      {
         list.add(rs.getString("user_account").replaceAll("\\s+", ""));
      }
      System.out.println(list);
      return list;
   }

   /** This method is returning the Id number of the User Account.
    * @param userAccount
    * @return rs.getInt() - returning the id of the user. 
    * @return -1 - if there is no such User Account.
    * @throws Exception
    */
   public int getIdForUser(String userAccount) throws Exception
   {
      String statement = "SELECT user_id FROM \"SEP DBS\".users WHERE user_account=?";
      PreparedStatement selectStatement = connection
            .prepareStatement(statement);
      selectStatement.setString(1, userAccount);
      ResultSet rs = selectStatement.executeQuery();

      while (rs.next())
      {
         return rs.getInt("user_id");

      }
      return -1;

   }

   /**This method is returning Passwords for all User Accounts.
    * @return list - returning list of user passwords
    * @throws Exception
    */
   public ArrayList<String> getAllUserPasswords() throws Exception
   {
      ArrayList<String> list = new ArrayList<>();

      String statement = "SELECT user_password FROM \"SEP DBS\".users";
      PreparedStatement selectStatement = connection
            .prepareStatement(statement);
      ResultSet rs = selectStatement.executeQuery();
      while (rs.next())
      {
         list.add(rs.getString("user_password").replaceAll("\\s+", ""));
      }
      System.out.println(list);
      return list;
   }

   /**This method is giving us all Administrator Accounts.
    * @return list - returning all Admin Accounts.
    * @throws Exception
    */
   public ArrayList<String> getAllAdmins() throws Exception
   {
      ArrayList<String> list = new ArrayList<>();

      String statement = "SELECT admin_account FROM \"SEP DBS\".administrator";
      PreparedStatement selectStatement = connection
            .prepareStatement(statement);
      ResultSet rs = selectStatement.executeQuery();
      while (rs.next())
      {
         list.add(rs.getString("admin_account").replaceAll("\\s+", ""));
      }
      System.out.println(list);
      return list;
   }

   /**This method is returning all password for Administrator Accounts.
    * @return list - returning list of all Admin passwords
    * @throws Exception
    */
   public ArrayList<String> getAllAdminPasswords() throws Exception
   {
      ArrayList<String> list = new ArrayList<>();

      String statement = "SELECT admin_password FROM \"SEP DBS\".administrator";
      PreparedStatement selectStatement = connection
            .prepareStatement(statement);
      ResultSet rs = selectStatement.executeQuery();
      while (rs.next())
      {
         list.add(rs.getString("admin_password").replaceAll("\\s+", ""));
      }
      return list;
   }
/**With this method we are modifying User Credentials.
 * @param userAccount
 * @param userPassword
 * @param userId
 * @throws SQLException
 */
   public void modifyUser(String userAccount, String userPassword, int userId)
         throws SQLException
   {
 
      String statement = "UPDATE \"SEP DBS\".users SET user_account = ? , user_password = ? WHERE user_id = ?";
      PreparedStatement updateStatement = connection
            .prepareStatement(statement);
      updateStatement.setString(1, userAccount);
      updateStatement.setString(2, userPassword);
      updateStatement.setInt(3, userId);
      updateStatement.executeUpdate();
      System.out.println("Record updated");
     
   }
/**With this method we are modifying Administrator credentials.
 * @param adminAccount
 * @param adminPassword
 * @param adminId
 * @throws SQLException
 */
   public void modifyAdmin(String adminAccount, String adminPassword,
         int adminId) throws SQLException
   {
   
      String statement = "UPDATE \"SEP DBS\".administrator SET admin_account = ? , admin_password = ? WHERE admin_id = ?";
      PreparedStatement updateStatement = connection
            .prepareStatement(statement);
      updateStatement.setString(1, adminAccount);
      updateStatement.setString(2, adminPassword);
      updateStatement.setInt(3, adminId);
      updateStatement.executeUpdate();
      System.out.println("Record updated");
   }

   /**With this method we are getting User Account while checking certain ID.
    * @param userId
    * @return rs.getString() - it's returning certain User Account
    * @return null - if there is no user with this ID
    * @throws SQLException
    */
   public String getUser(int userId) throws SQLException
   {
      String statement = "SELECT user_account FROM \"SEP DBS\".users WHERE user_id=?";
      PreparedStatement selectStatement = connection
            .prepareStatement(statement);
      selectStatement.setInt(1, userId);
      ResultSet rs = selectStatement.executeQuery();

      while (rs.next())
      {
         return rs.getString("user_account");

      }
      return null;
   }


}
