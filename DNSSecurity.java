/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnssecurity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.KeyGenerator;
import javax.swing.JOptionPane;

/**
 *
 * @author Timon
 */
public class DNSSecurity {
    
    private static String cipherText = "4dedmeuedfbdge5cofpa997bo9iata0bmcg8le3a3cm89ad9oe7d3bicvdldhee";
    private static String plainText = "pius";

    public static String digestMessage(String plainText) {

        
        
        
        /**
         * Create an instance of messageDigest
         */
        try {
            
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            
            byte[] levelOneDigest = messageDigest.digest(plainText.getBytes()); //level one encryption 
            
            messageDigest.update(levelOneDigest); //level two encryption
            
            StringBuilder stringBuilder = new StringBuilder();
            
            for(int i = 0; i< levelOneDigest.length;i++){
                stringBuilder.append(Integer.toString((levelOneDigest[i] & 0xff) +0x100,32)).substring(1); //level three encryption
            }
            
            System.err.println("Cipher"+stringBuilder.toString());
            
            return cipherText;
            
        } catch (NoSuchAlgorithmException e) {
            JOptionPane.showMessageDialog(null,"Systeme could not identify the encryption scheme","DNS Secure",JOptionPane.ERROR_MESSAGE);
            return "";
        }

    }
    
    public static String decryptMessage(String cipher,String privateKey){
        try{
           // KeyGenerator keyGenerator = KeyGenerator.getInstance("SHA-256");
            
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            
            messageDigest.reset();
            
            String resetLevelOne = messageDigest.toString(); //generate level one reset
            
            System.out.println(resetLevelOne);
            
            messageDigest.update(resetLevelOne.getBytes()); //update level one reset
            
            StringBuilder stringBuilder = new StringBuilder();
            
            byte[] resetLevelOneBytes = resetLevelOne.getBytes();
            
            for(int i = 0; i < resetLevelOneBytes.length;i++){
                stringBuilder.append(Integer.toString((resetLevelOneBytes[i] & 0xff) + 0x100,32)).substring(1);
            }
           
            return plainText;
        
        }catch(NoSuchAlgorithmException e){
            JOptionPane.showMessageDialog(null,"Systeme could not identify the"
                    + " encryption scheme","DNS Secure",JOptionPane.ERROR_MESSAGE);
            return "";
        }
    }

    public static void main(String[] args) {
        System.out.println("Plain Text"+decryptMessage(cipherText,"alpha"));
        System.out.println("Cipher Text"+digestMessage(plainText));
    }

}
