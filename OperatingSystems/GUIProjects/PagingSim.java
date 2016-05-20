/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.JOptionPane;

/**
 *Documentation
 * @author Jeffrey
 */
public class PagingSim {
   
    //Once upon a time
    public void work(){
        long add = 0;
         String address = JOptionPane.showInputDialog(null, "Please enter address: ");
         try{
            add = Integer.parseInt(address);
         }catch(Exception e){   //Bad stuff happened.
             JOptionPane.showMessageDialog(null, "words");
             System.exit(0);
         }
         if(add < 0){ // Bad input!
             System.out.println("Exiting");
             System.exit(0);
         }
         if(add >= Integer.MAX_VALUE){ //More bad input!
             System.out.println("Too large");
         }
         /**
          * MATHEMATICAL!
          */
         long pageNum = add/4096;
         long pageOffset = pageNum * 4096;
         add -= pageOffset;
         //Results
         JOptionPane.showMessageDialog(null, "Page: " + pageNum + " Offset: " + add);
         
    }
    
}
//And they lived happily ever after.