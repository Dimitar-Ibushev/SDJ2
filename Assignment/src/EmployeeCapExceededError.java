//will be thrown if user attempts to add too many Employees to the List
@SuppressWarnings("serial")
public class EmployeeCapExceededError extends RuntimeException
{
   public EmployeeCapExceededError()
   {
      super("Employee Cap Exceeded!");
   }
}
