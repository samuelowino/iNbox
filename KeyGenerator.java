/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnssecurity;

/**
 *
 * @author Timon
 */
public class KeyGenerator {
    
    
    private static KeyGenerator keyGenerator;
    
    /**
     *Obtains a pseudo random public key 
     * @return String public key
     */
    public KeyGenerator(){
        keyGenerator = new KeyGenerator();
    }
    
    public static String generatePublicKey(){
       
        
        String publicKey = keyGenerator.generatePublicKey();
        
        return publicKey;
        
    }
    
    public static String getPrivateKey(){
        
        String privateKey = keyGenerator.getPrivateKey();
        
        return privateKey;
    }
    
   
}
