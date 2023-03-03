import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class ClientMain
{
   public static void main(String args[]) throws IOException, UnknownHostException, ClassNotFoundException
   {
      final int PORT = 6789;
      final String HOST = "localhost";
      
      Socket clientSocket = new Socket(HOST, PORT);
      System.out.println("Client> connected to server");
      
      ObjectOutputStream outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
      
      ObjectInputStream inFromServer = new ObjectInputStream(clientSocket.getInputStream());
      
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Write a line for the server:  ");
      String inputLine = keyboard.nextLine();
      keyboard.close();
      
      Message message = new Message(inputLine);
      System.out.println("Client> " + message);
      outToServer.writeObject(message);
      
      Message replyMessage = (Message) inFromServer.readObject();
      System.out.println("Server> " + replyMessage);
      clientSocket.close();
   }
}
