
public class SalariedEmployee extends Employee
{
   private double weeklySalary;
   
   public SalariedEmployee(String name, Date birthday, double weeklySalary)
   {
      super(name, birthday);
      this.setWeeklySalary(weeklySalary);
   }

   public double getWeeklySalary()
   {
      return weeklySalary;
   }

   public void setWeeklySalary(double weeklySalary)
   {
      this.weeklySalary = weeklySalary;
   }
   
   public double earningsPWeek()
   {
      return weeklySalary;
   }
   
   public String toString()
   {
      return super.toString() + "\nWeekly Salary: " + weeklySalary;
   }
   
   public boolean equals(Object obj)
   {
      if(!(obj instanceof SalariedEmployee))
         return false;
      
      SalariedEmployee other = (SalariedEmployee)obj;
      return super.equals(other) && weeklySalary == other.weeklySalary;
   }
}
