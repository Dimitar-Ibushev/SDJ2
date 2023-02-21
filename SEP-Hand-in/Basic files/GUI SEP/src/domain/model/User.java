package domain.model;

import domain.mediator.ServerModelManager;

public class User
{
   private String userName;
   private String password;
   private int id;

   public User(String userName, String password)
   {
      this.userName = userName;
      this.password = password;

   }

   public String getUserName()
   {
      return userName;
   }

   public void setUser(String userName, String password,int userId)
   {
      this.userName = userName;
      this.password = password;
      this.id=userId;
   }

   public String getPassword()
   {
      return password;
   }

   public String toString()
   {
      return "User: " + userName + ",id: " + password;
   }

   public boolean checkIdentity(String userName, String password)
   {
      if (this.userName == userName && this.password == password)
         return true;
      return false;
   }

}