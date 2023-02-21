package utility.collection;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class ReservationsFileAdapter implements Serializable
{
   private MyFileIO mfio;
   private String fileName;
   
   public ReservationsFileAdapter(String fileName)
   {
      mfio = new MyFileIO();
      this.fileName = fileName;
   }
   
   public void SaveReservations(Reservation res)
   {
      try
      {
         mfio.writeToFile(fileName, res);
      }
      catch (FileNotFoundException e)
      {
      System.out.println("File not found");
      }
      catch (IOException e)
      {
      System.out.println("IO Error writing to file");
      }
   }
   
   public ArrayList getReservationsByInterval(String interval) throws FileNotFoundException, ClassNotFoundException, IOException
   {

      Reservation reservations  = (Reservation) mfio.readObjectFromFile(fileName);

      ArrayList<Reservation> list = new ArrayList<Reservation>();
      
      for(int i = 0; i < reservations.getLength(); i++)
      {
         if(reservations.getReservation(i).getDesiredInterval().getMonth().toLowerCase().equals(interval.toLowerCase()))
         {
            list.add(reservations.getReservation(i));
         }
      }
      
      return list;
   }
}
