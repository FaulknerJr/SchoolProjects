/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jeffrey
 */
public class NameClient {
    
    public void work(){
        Socket sock = null;
        try { 
            
            String ip = JOptionPane.showInputDialog(null, "IpAddress?");
            InetAddress location = InetAddress.getByName(ip);
            String strPort = JOptionPane.showInputDialog(null,"Enter port number");
            int port = 0;
            port = Integer.parseInt(strPort);
            sock = new Socket(location, port);
            DataInputStream dis = new DataInputStream(sock.getInputStream());
            
            dis.read();
            
            sock.close();
            dis.close();
            
            
        } catch (Exception ex) {
            Logger.getLogger(NameClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
