
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;
/**
 *  Copies a specified file byte by byte.
 *  Tested using .txt files. Initially, had a problem because I forgot extension.
 *  After placing extension program worked properly.
 *  Another problem that occurred was false duplication messages. This should
 *      be rectified but no guarantees.
 * 
 * @author Jeffrey Faulkner
 */
public class FileCopy {
    
        public void work() {
        try {
            //Opens fis
            try (FileInputStream fis = new FileInputStream(JOptionPane.showInputDialog(null, "Please enter file path name you want copied."))) {
                File newFile = new File(JOptionPane.showInputDialog(null, "Please name copied file name."));
                //Opens fos
                try (FileOutputStream fos = new FileOutputStream(newFile)) {
                    //Checks for file duplication if so asked to change name otherwise overwritten.
                    if(!newFile.exists()){
                        int i = 0;
                        while(newFile.exists()){
                            newFile = new File(JOptionPane.showInputDialog(null, "File name used please enter new one"));
                            ++i;
                            if(i == 2){
                                JOptionPane.showMessageDialog(null, "File being overwritten");
                                newFile.createNewFile();
                            }
                        }
                    }
                    else{
                        newFile.createNewFile();
                    }
                    //Had dropped bits here reworked to current. 
                    //Should not be a problem anymore.
                    int data = fis.read();
                    while(data >= 0){
                        
                        fos.write(data);
                        data = fis.read();
                    }
                    fos.close();
                }
                fis.close();
                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
           // br.close();
            
        }
    }
    
}
/**
 * String data = page.getText();
 * fos.write(data.getBytes());
 * fos.close();
 */