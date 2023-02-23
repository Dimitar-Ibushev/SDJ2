
public class HourlyEmployee extends Employee
{
   private double wagePHour;
   private double hoursWorkedPWeek;
   
   public HourlyEmployee(String name, Date birthday, double wagePHour, double hoursWorkedPWeek)
   {
      super(name, birthday);
      this.setWagePHour(wagePHour);
      this.setHoursWorkedPWeek(hoursWorkedPWeek);
   }

   public double getWagePHour()
   {
      return wagePHour;
   }

   public void setWagePHour(double wagePHour)
   {
      this.wagePHour = wagePHour;
   }

   public double getHoursWorkedPWeek()
   {
      return hoursWorkedPWeek;
   }

   public void setHoursWorkedPWeek(double hoursWorkedPWeek)
   {
      this.hoursWorkedPWeek = hoursWorkedPWeek;
   }
   
   public double earningsPWeek()
   {
      return hoursWorkedPWeek*wagePHour;
   }
   
   public String toString()
   {
      return super.toString() + "\nWage per Hour:" + wagePHour + "\nHours Worked per Week: " + hoursWorkedPWeek + "\nEarnings per Week: " + earningsPWeek();
   }
   
   public boolean equals(Object obj)
   {
      if(!(obj instanceof HourlyEmployee))
         return false;
      
      HourlyEmployee other = (HourlyEmployee)obj;
      return super.equals(other) && hoursWorkedPWeek == other.hoursWorkedPWeek && wagePHour == other.wagePHour;
   }
}
