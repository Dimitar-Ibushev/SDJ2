package utility.collection;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RmiServer extends UnicastRemoteObject implements ServerInterface
{
   
  private ReservationsFileAdapter adapt;
   public static void main(String[] args)
   {
      try
      {
         Registry reg = LocateRegistry.createRegistry(1099);
         ServerInterface rmiServer = new RmiServer();
         System.out.println("Starting server...");
         Naming.rebind("getReservationsByInterval", rmiServer);
      }
      catch (Exception ex)
      {
         ex.printStackTrace();
      }
   }
   
   public RmiServer() throws RemoteException
   {
      super();
      adapt = new ReservationsFileAdapter("reservations.bin");
   }
   
   public String getReservationsByInterval(String month, Object client) throws RemoteException {
      ArrayList<Reservation> reservations = new ArrayList<>();
      try {
         reservations = adapt.getReservationsByInterval(month);
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
      return reservations.toString();
   }
}
