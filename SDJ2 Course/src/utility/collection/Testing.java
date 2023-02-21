package utility.collection;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Testing
{
   public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException
   {
   
   Reservation first = new Reservation("Person", "London", "january", 5);
   Reservation second = new Reservation("Mensch", "Berlin", "january", 11);
   Reservation third = new Reservation("Chovek", "Sofia", "february", 6);
   
   ArrayList<Reservation> list = new ArrayList<Reservation>();
   
   list.add(first);
   list.add(second);
   list.add(third);
   
   Reservation reservations = new Reservation(list);
   
   ReservationsFileAdapter adapter = new ReservationsFileAdapter("reservations.bin");
   
   adapter.SaveReservations(reservations);
   
   System.out.println(adapter.getReservationsByInterval("january"));
   }
}
