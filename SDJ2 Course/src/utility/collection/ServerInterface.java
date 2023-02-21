package utility.collection;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ServerInterface extends Remote
{
   String getReservationsByInterval(String month, Object client) throws RemoteException;
}
