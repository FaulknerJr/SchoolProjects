

package myserverchat;

import java.net.*;
import java.io.*;

/**
 * This program allows two computers to communicate using a UDP connection.
 * There are two projects and two classes (server and client) included in this program. 
 * This is the server project and class.
 * For this program to work the client must chat first and typing "bye" in either
 * the server or client chat will stop the program.
 * @author Jeffrey Faulkner
 */
public class MyServerChat {

   
    public static void main(String[] args) throws IOException{
       
        int port = 4000;
        DatagramSocket socket = new DatagramSocket(port); 
        
        InetAddress addr = InetAddress.getLocalHost();
        System.out.println("IP address: " + addr.getHostAddress());
        System.out.println("Port number: " + socket.getLocalPort() + "\n");
     
        //This loop will  receive requests/messages from the client and send messages to the client 
      while(true) 
        { 
          byte[] rbuffer = new byte[1024]; 
          byte[] sbuffer  = new byte[1024]; 
          
          DatagramPacket packet = new DatagramPacket(rbuffer, rbuffer.length); 
          socket.receive(packet); 
          InetAddress IP = packet.getAddress(); //server IP address
          int rPort = packet.getPort();
          
          String clientdata = new String(packet.getData()); 
          
          System.out.println("Client: "+ clientdata);   //Will show who is talking in the chat
          System.out.print("Server: ");     //Will show who is talking in the chat
          
          BufferedReader input = new BufferedReader(new InputStreamReader (System.in) ); 
          String data = input.readLine(); 
          
          if(data.equalsIgnoreCase("bye"))      //Close the program if the server types "bye"
          {                                    //The case of the word is ignored
                                              
              break;
          }        
          
          sbuffer = data.getBytes(); 
          DatagramPacket sendPacket = new DatagramPacket(sbuffer, sbuffer.length, IP, rPort); 
          socket.send(sendPacket);     
        }  
    }// end main
}// end MyServerChat

   
    

