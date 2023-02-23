/*tests all the methods from question 2 including the Date class (I did q2 first, looked more straightforward)
remove the slashes before the print methods to get the desired results*/
public class Q2_Test
{
   @SuppressWarnings("unused")
   public static void main(String[] args)
   {
      
      /*Creating a new Date*/
      
      Date date1 = new Date(7, 10, 1997);
      
      //System.out.println(date1);
      

      /*Creating a copy*/
      //System.out.println(date1.copy());
      
      /*Equal Dates*/
      
      Date date2 = new Date(15, 8, 1980);
      //System.out.println(date1.equals(date2));
      //System.out.println(date1.equals(date1.copy()));
      
      /*Creating an Employee of each kind*/
      
      Employee employee1 = new HourlyEmployee("Mark", new Date(11, 6, 1976), 20, 30);
      Employee employee2 = new SalariedEmployee("Stacy", date1, 500);
      
      //System.out.println(employee1);
      //System.out.println(employee2);
      
      /*creating an EmployeeList*/
      
      EmployeeList list = new EmployeeList(3);
      //System.out.println(list);
      
      /* enabling this will result in an error message that there are no employees*/
      
      try
      {
      //System.out.println(list.getAllEmployees());
      }
      catch(NoEmployeesError e)
      {
         System.out.println(e.getMessage());
      }

      
      /*adding employees and attempting to exceed cap.
       *  The fact wage gets displayed right also means that getWage methods work in all classes*/
      
      Employee employee3 = new HourlyEmployee("Mark", new Date(11, 6, 1976), 20, 30);
      Employee employee4 = new SalariedEmployee("Stacy", date1, 500);

      try
      {
         list.addEmployee(employee1);
      }
      catch(EmployeeCapExceededError e)
      {
         System.out.println(e.getMessage());
      }
      
      try
      {
         list.addEmployee(employee2);
      }
      catch(EmployeeCapExceededError e)
      {
         System.out.println(e.getMessage());
      }
      
      try
      {
         list.addEmployee(employee3);
      }
      catch(EmployeeCapExceededError e)
      {
         System.out.println(e.getMessage());
      }
      
      /* enabling this will result in an error message*/
      try
      {
         //list.addEmployee(employee4);
      }
      catch(EmployeeCapExceededError e)
      {
         System.out.println(e.getMessage());
      }
      
      //System.out.println(list);

      /*returns all the employees.*/ 
      try
      {
         //System.out.println(list.getAllEmployees());
      }
      catch(NoEmployeesError e)
      {
         System.out.println(e.getMessage());
      }

   }
}
