/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Scanner;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jeffrey
 */
public class NameServer implements Runnable {

    int port;
    ExecutorService pool;
    Scanner user = new Scanner(System.in);
    TimerTask tt;
    
//    public static void main(String [] args){
//        NameServer ns = new NameServer();
//        //+ns.run();
//    }
    
    public void run() {
        do {
            String strPort = JOptionPane.showInputDialog(null, "Port number?");
            port = Integer.parseInt(strPort);
        } while (port < 80 || port > 65535);
        pool = Executors.newCachedThreadPool();

        try {
            ServerSocket ss = new ServerSocket(port);
            ss.accept(); long time; String stuff = "";
            //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while(true){
                pool.execute(new WorkerClass());
                time = System.currentTimeMillis();
                while((System.currentTimeMillis() - time) < 2500){
                    if((stuff = user.next()).equals("done") ){
                        break;
                    }
                }
                if(stuff.equals("done")){
                    break;
                }
                else if (time >= 500){
                    //Dance. Do Absolutely Nothing Computer Entity.
                }
            }
            pool.shutdown();
            ss.close();
        } catch (IOException ex) {
            Logger.getLogger(NameServer.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }

    public void stop() {
        System.exit(0);
    }
    //executors.newCacheThreadPool();

}
