import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerMain
{
   public static void main(String args[]) throws IOException, ClassNotFoundException
   {
      boolean isConnected = true;
      final int PORT = 6789;
      System.out.println("Starting server...");
      
      ServerSocket welcomeSocket = new ServerSocket(PORT);
      
      while(isConnected)
      {
         System.out.println("Waiting for a client...");
         Socket connectionSocket = welcomeSocket.accept();
         
         ObjectOutputStream outToClient = new ObjectOutputStream(connectionSocket.getOutputStream());
         
         ObjectInputStream inFromClient = new ObjectInputStream(connectionSocket.getInputStream());
         
         Message message = (Message) inFromClient.readObject();
         System.out.println("Message from client: " + message);
         
         Message replyMessage = new Message(message.getId(), message.getBody().toUpperCase());
         System.out.println("Server reply: " + replyMessage);
         outToClient.writeObject(replyMessage);
      }
      welcomeSocket.close();
   }
   
   
}
