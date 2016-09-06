/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

 import javax.crypto.spec.SecretKeySpec;
  import javax.crypto.spec.IvParameterSpec;
   
  import javax.crypto.Cipher;
import javax.swing.JOptionPane;
   
  public class EncriptaDecriptaAES {
         
         static String IV = "AAAAAAAAAAAAAAAA";
         static String textopuro =  JOptionPane.showInputDialog("Digite o texto");
         static String chaveencriptacao = "0123456789abcdef";
   
         public static void main(String [] args) {
   
               try {
                      
                      System.out.println("Texto Puro: " + textopuro);
                       
                      byte[] textoencriptado = encrypt(textopuro, chaveencriptacao);
                       
                      System.out.print("Texto Encriptado: ");
   
                      for (int i=0; i<textoencriptado.length; i++)
                             System.out.print(new Integer(textoencriptado[i])+" ");
                      
                      System.out.println("");
                       
                      String textodecriptado = decrypt(textoencriptado, chaveencriptacao);
                       
                      System.out.println("Texto Decriptado: " + textodecriptado);
                
               } catch (Exception e) {
                      e.printStackTrace();
               }
         }
   
         public static byte[] encrypt(String textopuro, String chaveencriptacao) throws Exception {
               Cipher encripta = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
               SecretKeySpec key = new SecretKeySpec(chaveencriptacao.getBytes("UTF-8"), "AES");
               encripta.init(Cipher.ENCRYPT_MODE, key,new IvParameterSpec(IV.getBytes("UTF-8")));
               return encripta.doFinal(textopuro.getBytes("UTF-8"));
         }
   
         public static String decrypt(byte[] textoencriptado, String chaveencriptacao) throws Exception{
               Cipher decripta = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
               SecretKeySpec key = new SecretKeySpec(chaveencriptacao.getBytes("UTF-8"), "AES");
               decripta.init(Cipher.DECRYPT_MODE, key,new IvParameterSpec(IV.getBytes("UTF-8")));
               return new String(decripta.doFinal(textoencriptado),"UTF-8");
         }
         
  }