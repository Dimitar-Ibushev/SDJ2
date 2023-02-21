package utility.collection;

import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class RmiClient implements Serializable
{
      private ServerInterface server;
      
      public RmiClient() throws RemoteException
      {
         try
         {
            server = (ServerInterface) Naming.lookup("rmi://localhost:1099/getReservationsByInterval");
            String res = server.getReservationsByInterval("february",this);
            System.out.println(res);
         }
         catch(Exception e)
         {
            e.printStackTrace();
         }
      }
      
      public static void main(String[] args) throws RemoteException
      {
         RmiClient client = new RmiClient();
      }
}

