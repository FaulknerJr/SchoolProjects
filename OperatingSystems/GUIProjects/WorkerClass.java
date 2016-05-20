/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jeffrey
 */
public class WorkerClass implements Runnable {
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    InetAddress add;
    String url;
    

    @Override
    public void run() {
        try {
            url = br.readLine();
        } catch (IOException ex) {
            Logger.getLogger(WorkerClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            add = InetAddress.getByName(new URL(url).getHost());
        } catch (MalformedURLException | UnknownHostException ex) {
            Logger.getLogger(WorkerClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(add.getHostAddress());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
