package utility.collection;

import java.io.Serializable;
import java.util.ArrayList;


public class Reservation implements Serializable
{
   private String customer;
   private String destination;
   private DesiredInterval month;
   private int depDay;
   private ArrayList<Reservation> reservations;
   
   public Reservation(String customer, String destination, String month, int depDay)
   {
      this.customer = customer;
      this.destination = destination;
      this.depDay = depDay;
      this.month = IntervalFactory.getInterval(month);
      reservations = new ArrayList<>();
      this.reservations = reservations;
   }
   
   public Reservation(ArrayList<Reservation> list)
   {
      this.reservations = new ArrayList<Reservation>();
      this.reservations = list;
   }

   public String getInfo()
   {
      return "\nReservation by: " + customer + "\nTo: " + destination +
             "\nLeaving on: " + depDay  + "/" + month.getMonthNumber();
   }
   
   public DesiredInterval getDesiredInterval()
   {
      return month;
   }
   
   public String toString()
   {
      return "Reservation by: " + customer + "\nTo: " + destination +
            "\nLeaving on: " + depDay  + "/" + month.getMonthNumber();
   }
   public int getLength() {
      return reservations.size();
   }
   public Reservation getReservation(int index) {
      return reservations.get(index);
   }
}
