import java.util.ArrayList;

public class Notebook
{
   private int numberOfNotes;
   private ArrayList<Note> notes;
   
   public Notebook(int maxNumberOfNotes)
   {
      numberOfNotes = maxNumberOfNotes;
      notes = new ArrayList<Note>();
   }
   
   public void addNote(Note note)
   {
      if(notes.size()==numberOfNotes)
         throw new TooManyNotes();
      notes.add(note);
   }
   
   public void setNote(Note note, int index)
   {
      notes.set(index, note);
   }
   
   public void removeNote(int index)
   {
      notes.remove(index);
   }
   
   public Note getNote(int index)
   {
      return notes.get(index);
   }
   
   //loops once over all the notes and adds 1 to the counter each time it encounters an instance of Priority Note class
   public int getNumberOfPriorityNotes()
   {
      int a = 0; //counter
      for(int i = 0; i < notes.size(); i++)
      {
         if(notes.get(i) instanceof PriorityNote)
            a++;
      }
      return a;
   }
   
   //loops through all the notes 3 times and adds them to a new array list in the desired order
   //like in Q2, I decided to use array list instead of simple array
   public ArrayList<Note> getPriorityNotes()
   {
      ArrayList<Note> priority = new ArrayList<Note>();
      for(int i = 0; i < notes.size(); i++)
      {
         if(notes.get(i) instanceof PriorityNote && ((PriorityNote) notes.get(i)).getPriority() == 1)
            priority.add(notes.get(i));
      }
      
      for(int i = 0; i < notes.size(); i++)
      {
         if(notes.get(i) instanceof PriorityNote && ((PriorityNote) notes.get(i)).getPriority() == 2)
            priority.add(notes.get(i));
      }
      
      for(int i = 0; i < notes.size(); i++)
      {
         if(notes.get(i) instanceof PriorityNote && ((PriorityNote) notes.get(i)).getPriority() == 3)
            priority.add(notes.get(i));
      }
      
      return priority;
   }
   
   public String toString()
   {
      return "\nMax Number of Notes: " + numberOfNotes + "\nCurrent Number of Notes: " + notes.size() + notes;
   }
}
