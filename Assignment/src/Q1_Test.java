
/*I decided to do Q2 first, so it might be better to refer to Q2_Test before checking this one.
 *Testing that one includes the Date class
 */
public class Q1_Test
{
   @SuppressWarnings("unused")
   public static void main(String[] args)
   {
      Note note1 = new DatedNote("A", new Date(5, 10, 2017));
   
      //System.out.println(note1);
      
      Note note2 = null;
     
      /*changing the priority value to an illegal one here will result in an error message
       * and it being changed to lowest possible (typically all notes would be written like this)*/
     try
     {
        note2 = new PriorityNote("B", 3);
     }
     catch(IllegalNotePriority e)
     {
        System.out.println(e.getMessage());
        note2 = new PriorityNote("B", 3);
     }
     
      //System.out.println(note2);
      
      Note note3 = new PriorityNote("C", 1);
      Note note4 = new PriorityNote("D", 2);
      Note note5 = new PriorityNote("E", 1);
      Note note6 = new PriorityNote("F", 1);
      
      /*Creating Notebook*/
      
      Notebook notebook = new Notebook(5);
      try
      {
         notebook.addNote(note1);
      }
      catch(TooManyNotes e)
      {
         System.out.println(e.getMessage());
      }
      
      try
      {
         notebook.addNote(note2);
      }
      catch(TooManyNotes e)
      {
         System.out.println(e.getMessage());
      }
      
      try
      {
         notebook.addNote(note3);
      }
      catch(TooManyNotes e)
      {
         System.out.println(e.getMessage());
      }
      
      try
      {
         notebook.addNote(note4);
      }
      catch(TooManyNotes e)
      {
         System.out.println(e.getMessage());
      }
      
      try
      {
         notebook.addNote(note5);
      }
      catch(TooManyNotes e)
      {
         System.out.println(e.getMessage());
      }
      
      /* Enabling this will get an error*/
      try
      {
         //notebook.addNote(note6);
      }
      catch(TooManyNotes e)
      {
         System.out.println(e.getMessage());
      }
      
      /*Removing notes/setting notes*/
      //notebook.removeNote(0);
      //notebook.setNote(note6, 0);
      //System.out.println(notebook);
      
      /*Getting number of priority notes*/
      //System.out.println(notebook.getNumberOfPriorityNotes());
      
      /*getting all priority notes*/
      //System.out.println(notebook.getPriorityNotes());
   }
}
