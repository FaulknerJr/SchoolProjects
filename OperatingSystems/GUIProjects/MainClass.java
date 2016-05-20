/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Jeffrey
 */
public class MainClass implements ActionListener{
   
    JButton b1, b2, b3, b4, b5;
    
    public static void main(String [] args){
        MainClass mc = new MainClass();
        mc.init();
    }
    
    public void init(){
        JFrame jf = new JFrame();
        JPanel jp = new JPanel();
        
        b1 = new JButton("1. File Copy");
        b2 = new JButton("2. Name Client(Does Not work!)");
        b3 = new JButton("3. Name Server");
        b4 = new JButton("4. Paging Sim");
        b5 = new JButton("5. Exit");
        jp.add(b1);
        jp.add(b2);
        jp.add(b3);
        jp.add(b4);
        jp.add(b5);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        jf.add(jp);
        jf.setVisible(true);
        jf.setSize(500, 500);
        jf.setResizable(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void response(){
	System.out.println(“Does not work.”);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == b1){
            FileCopy fc = new FileCopy();
            fc.work();
        }
        else if(e.getSource() == b2){
            //JOptionPane.showMessageDialog(null, “This does not work. \n Exiting System.“);  
            //System.out.println(\“This one doesn\’t work. Exiting system\”);          
            System.exit(0);
        }
        else if(e.getSource() == b3){
            JOptionPane.showMessageDialog(null, "This is starting a server");
            NameServer ns = new NameServer();
            ns.run();
        }
        else if(e.getSource() == b4){
            PagingSim ps = new PagingSim();
            ps.work();
        }
        else{
            System.exit(0);
        }
    }
    
}
