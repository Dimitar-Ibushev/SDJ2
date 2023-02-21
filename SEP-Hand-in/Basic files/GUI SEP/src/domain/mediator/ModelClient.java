package domain.mediator;

import domain.model.Message;
/**
 * 
 * @author Daniel Borisov
 *
 */
public interface ModelClient
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
    * Adding messages into list that holds objects.
    * @param message
    */
   void addMessageInModel(Message message);

   /**
    * Its notyfying all clients for new massages.
    * @param message
    */
   void notifyAboutMessage(Message message);
   
   /**
    * With this method we are checking if the User credentials are correct
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
   /**
    * This method is giving us the ID for a certain User account.
    * @param userAccount
    * @return
    * @throws Exception
    */
   int getIdForUserFromDatabase(String userAccount) throws Exception;
}
