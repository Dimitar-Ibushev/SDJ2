
@SuppressWarnings("serial")
public class TooManyNotes extends RuntimeException
{
   public TooManyNotes()
   {
      super("Can't add any more notes!");
   }
}
