package domain.model;

public class Administrator
{
   private String userName;
   private String password;
   private int id;

   public Administrator(String userName, String password)
   {
      this.userName = userName;
      this.password = password;
      

   }

   public String getUserName()
   {
      return userName;
   }

   public void setAdministrator(String userName, String password, int adminId)
   {
      this.userName = userName;
      this.password = password;
      this.id=adminId;
   }

   public String getPassword()
   {
      return password;
   }
   
   public boolean checkIdentity(String userName, String password)
   {
      if(this.userName==userName && this.password==password)
         return true;
      return false;
   }

   public String toString()
   {
      return "Administrator: "+userName+",id: "+id;
   }
}
