
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * I CAN NOT BE HELD RESPONSIBLE IF YOU IGNORE THE FOLLOWING WARNINGS.
 * THIS PROGRAM WILL RUN YOUR CPU AT 100% WHILE SIMULTANEOUSLY OPENING WINDOWS.
 * I DO NOT KNOW IF YOU WILL BE ABLE TO END THE PROGRAM UPON RUNNING. 
 * IF YOU DO RUN THIS PROGRAM MY ONLY SUGGESTION IS TO REMOVE POWER FROM THE COMPUTER AS SOON AS POSSIBLE.
 * @author Jeffrey Faulkner
 */

/**
 *  DO NOT RUN THIS PROGRAM
 *  DO NOT RUN THIS PROGRAM
 *  DO NOT RUN THIS PROGRAM
 *  DO NOT RUN THIS PROGRAM
 *  DO NOT RUN THIS PROGRAM
 *  DO NOT RUN THIS PROGRAM
 *  DO NOT RUN THIS PROGRAM
 *  DO NOT RUN THIS PROGRAM DO NOT RUN THIS PROGRAM
 *  DO NOT RUN THIS PROGRAM DO NOT RUN THIS PROGRAM
 *  DO NOT RUN THIS PROGRAM DO NOT RUN THIS PROGRAM
 *  DO NOT RUN THIS PROGRAM DO NOT RUN THIS PROGRAM
 *  DO NOT RUN THIS PROGRAM DO NOT RUN THIS PROGRAM
 *  DO NOT RUN THIS PROGRAM DO NOT RUN THIS PROGRAM
 *  DO NOT RUN THIS PROGRAM DO NOT RUN THIS PROGRAM
 *  DO NOT RUN THIS PROGRAM DO NOT RUN THIS PROGRAM
 *  DO NOT RUN THIS PROGRAM DO NOT RUN THIS PROGRAM
 *  DO NOT RUN THIS PROGRAM DO NOT RUN THIS PROGRAM
 *  DO NOT RUN THIS PROGRAM DO NOT RUN THIS PROGRAM
 *  DO NOT RUN THIS PROGRAM DO NOT RUN THIS PROGRAM
 *  DO NOT RUN THIS PROGRAM DO NOT RUN THIS PROGRAM
 *  DO NOT RUN THIS PROGRAM DO NOT RUN THIS PROGRAM
 *  DO NOT RUN THIS PROGRAM DO NOT RUN THIS PROGRAM
 *  DO NOT RUN THIS PROGRAM
 * @author Jeffrey Faulkner
 */
public class NewClass implements KeyListener{

    private static int pig = 10000;
    KeyListener kL;
    
    public static void main(String[] args) {
        JOptionPane.showConfirmDialog(null, "Are you sure you want to run this?");
        JOptionPane.showMessageDialog(null, "To quit open terminal /k");
        while(true){
        try {
            int i, j, k, unknown = 0, bravo = 0, charlie = 0;
            while (true) {
                for (i = 0; i < hog.length; ++i) {
                    for (j = 0; j < hog[0].length; ++j) {
                        bravo = j;
                        for (k = 0; k < hog[0][0].length; ++k) {
                            hog[i][j][k] = new Piggies(pig);
                            pig += hog[i][j][k].toOmega();
                            //Thread.sleep(i);
                        }
                    }
                }
                
            }
        } 
        catch (Exception e) {
            System.out.println("Running again good luck");
        }
    }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //athrow new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == 'a'){
            System.exit(0);
        }
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyChar() == 'a'){
            System.exit(0);
        }
        //throw new UnsupportedOperationException("Not supported yet.");
    }
}
