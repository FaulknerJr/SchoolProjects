package myclientchat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.*;
import java.io.*;

/**
 * This program allows two computers to communicate using a UDP connection.
 * There are two projects and two classes (server and client) included in this
 * program. This is the client project and class. For this program to work the
 * client must chat first and typing "bye" in either the server or client chat
 * will stop the program.
 *
 * @author Jeffrey Faulkner
 */
public class MyClientChat {
    
    public static void main(String[] args) throws IOException {

       //This loop will send messages to the server and receive requests/messages from the server
       
        while (true) {
            
            BufferedReader clientRead = new BufferedReader(new InputStreamReader(System.in));

           //Creates the UDP socket
            DatagramSocket clientSocket = new DatagramSocket();
            
            //This IP address needs hardcoded in for where the server is running
            InetAddress IP = InetAddress.getByName("192.168.148.77");

            byte[] sendbuffer = new byte[1024];
            byte[] receivebuffer = new byte[1024];

            System.out.print("Client: "); //Will show who is talking in the chat (Client)

            //Reads the what the client types
            String clientData = clientRead.readLine();

            //If the client types "bye" no matter the case, the program will terminate
            if (clientData.equalsIgnoreCase("Bye")) {
                break;
            }

            sendbuffer = clientData.getBytes();
           //Send the message that the client types to the server
            DatagramPacket sendPacket = new DatagramPacket(sendbuffer, sendbuffer.length, IP, 4000);
            clientSocket.send(sendPacket);
            //Receives the message from the server  
            DatagramPacket receivePacket = new DatagramPacket(receivebuffer, receivebuffer.length);
            clientSocket.receive(receivePacket); 
            String serverData = new String(receivePacket.getData());
            System.out.println("Server: " + serverData); //Will show who is talking in the chat(Server)
            clientSocket.close();     //closes the client socket
        }

    }//end main
}
