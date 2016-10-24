/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author marcelobuzzeti
 */
public class EncryptorTest {
    public static void main(String[] args){
        try{
            JFileChooser chooser = new JFileChooser();
            if (chooser.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) System.exit(0);
            
            File inFile = chooser.getSelectedFile();
            if (chooser.showSaveDialog(null) != JFileChooser.APPROVE_OPTION) System.exit(0);
            
            File outFile = chooser.getSelectedFile();
            String input = JOptionPane.showInputDialog("Key");
            int key = Integer.parseInt(input);
            Encryptor crypt = new Encryptor(key);
            crypt.encryptFile(inFile, outFile);
        } catch (NumberFormatException exception){
            System.out.println("Key must be a integer:"+exception);
        } catch (IOException exception){
            System.out.println("Error processing file:"+exception);
        }
        System.exit(0);
    }
    
}
