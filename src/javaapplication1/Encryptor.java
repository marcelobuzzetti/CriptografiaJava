/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
/**
 *
 * @author marcelobuzzeti
 */
public class Encryptor {
    
private int key;    

    public Encryptor(int aKey){
        key = aKey;
    }
    
    public void encryptFile(File inFile, File outFile) throws IOException{
        InputStream in = null;
        OutputStream out = null;
        
        try{
            in = new FileInputStream(inFile);
            out = new FileOutputStream(outFile);
            encryptStream(in,out);
        }finally{
            if (in != null) in.close();
            if (out != null) out.close();
        }
    }
    
    public void encryptStream(InputStream in, OutputStream out) throws IOException{
        boolean done = false;
        while(!done){
            int next = in.read();
            if (next == -1) done = true;
            else{
                byte b = (byte)next;
                byte c = encrypt(b);
                out.write(c);
            }
        }
    }
    
    public byte encrypt(byte b){
        return (byte)(b + key);
    }
    
    public byte decrypt(byte b){
        return (byte)(b - key);
    }
}