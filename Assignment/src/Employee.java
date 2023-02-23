
public abstract class Employee
{
   private String name;
   private Date birthday;
   
   public Employee(String name, Date birthday)
   {
      this.setName(name);
      //only better idea I have about setting birthday is creating a constructor
      //that takes Date as an argument
      this.birthday = new Date(birthday.getDay(), birthday.getMonth(), birthday.getYear());
   }

   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      this.name = name;
   }
   
   public Date getBirthday()
   {
      return birthday;
   }
   
   public String toString()
   {
      return "\nName: " + name + "\nBirthday: " + birthday.toString();
   }
   
   public boolean equals(Object obj)
   {
      if(!(obj instanceof Employee))
         return false;
      
      Employee other = (Employee)obj;
      return name.equals(other.name) && birthday.equals(other.birthday);
   }
   
   public abstract double earningsPWeek();
}
