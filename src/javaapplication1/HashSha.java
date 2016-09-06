/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

 import java.io.UnsupportedEncodingException;
  import java.security.MessageDigest;
  import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;
   
  public class HashSha {
   
           public static void main(String args []) throws NoSuchAlgorithmException, UnsupportedEncodingException {
                     
                     String senha = JOptionPane.showInputDialog("Digite o texto");
                     
                     MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
                     byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));
                     
                      System.out.println("Texto original "+senha);
                     System.out.println("HASH "+messageDigest);
           }
           
  }
