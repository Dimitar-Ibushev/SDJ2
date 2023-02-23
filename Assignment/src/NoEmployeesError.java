//will be thrown if user attempts to get all employees but there are none
@SuppressWarnings("serial")
public class NoEmployeesError extends RuntimeException
{
   public NoEmployeesError()
   {
      super("There are no employees in the list!");
   }
}
