import java.util.ArrayList;


public class EmployeeList
{
   private int size;
   private ArrayList<Employee> employees;
   
   public EmployeeList(int maxNumberOfEmployees)
   {
      size = maxNumberOfEmployees;
      employees = new ArrayList<Employee>();
   }
   
   public void addEmployee(Employee employee)
   {
      //will throw an error if cap is reached when adding
      if(employees.size() == size)
         throw new EmployeeCapExceededError();
      
      else employees.add(employee);
   }
   
   //Decided to change the return type for this method. It's easier this way, besides arrays lack a toString method
   //still, if it were array return type, it would have to be as in the outcommented version of the method
   public ArrayList<Employee> getAllEmployees()
   {
      /*
      Employee arr[] = new Employee[employees.size()];
      
      for(int i=0; i < employees.size(); i++)
      {
         arr[i] = employees.get(i);
      }
      return arr;
      */
      
      if(employees.size() == 0)
         throw new NoEmployeesError();
      return employees;
   }
   
   public void removeEmployee(Employee employee)
   {
      employees.remove(employee);
   }
   
   public int getNumberOfEmployees()
   {
      return employees.size();
   }
   
   public double getTotalEarningsPWeek()
   {
      //creates an integer to store the value
      int a = 0;
      
      //makes a single loop through the employees, adding their wage to the int
      for(int i = 0; i < employees.size(); i++)
      {
         a += employees.get(i).earningsPWeek();
      }
      
      //returns the needed value
      return a;
   }
   
   public String toString()
   {
      //prints out the max and current number of employees and their total earnings per week
      return "Max Number of Employees: " + size +
             "\nCurrent Number of Employees: " + employees.size() +
             "\nTotal Earnings per Week: " + getTotalEarningsPWeek();
   }
   
   public boolean equals(Object obj)
   {
      if(!(obj instanceof EmployeeList))
         return false;
      
      EmployeeList other = (EmployeeList)obj;
      return size == other.size && getAllEmployees().equals(other.getAllEmployees()) && getTotalEarningsPWeek() == other.getTotalEarningsPWeek();
   }
}
