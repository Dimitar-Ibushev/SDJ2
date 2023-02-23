
@SuppressWarnings("serial")
public class IllegalNotePriority extends RuntimeException
{
   public IllegalNotePriority()
   {
      super("Not a valid priority. Priority will be set to lowest possible.");
   }
}
