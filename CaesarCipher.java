import edu.duke.*;
/**
 * Write a description of class CaesarCipher here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CaesarCipher
{
    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;
    public CaesarCipher(int key){
        alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet=alphabet.substring(key)+ alphabet.substring(0,key);
        mainKey=key;
    }
    
    public String encrypt(String input){
        StringBuilder encrypted= new StringBuilder(input);
        
        for (int i=0; i<encrypted.length();i++){
            char currChar=encrypted.charAt(i);
            int idx=alphabet.indexOf(Character.toUpperCase(currChar));
            if (idx!=-1){
                char newChar=shiftedAlphabet.charAt(idx);
                if (Character.isUpperCase(currChar)==true){
                    encrypted.setCharAt(i,newChar);
                }
                else{
                    encrypted.setCharAt(i,Character.toLowerCase(newChar));
                }
            }
        }
        return encrypted.toString();
    }
    
    public String decrypt(String input){
        CaesarCipher cc=new CaesarCipher(26-mainKey);
        return cc.encrypt(input);
    }
    
    
    
    public void testCaesar(){
        //System.out.println("Should be CFOPQ IBDFLK XQQXZH BXPQ CIXKH! / is - " +encrypt("FIRST LEGION ATTACK EAST FLANK!",23));
        //System.out.println("Should be Cfopq Ibdflk / is - " +encrypt("First Legion",23));
        //System.out.println("Should be Wzijk Cvxzfe / is - " +encrypt("First Legion", 17));
        //System.out.println(encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!",15));
        int key=23;
        FileResource fr=new FileResource();
        String message=fr.asString();
        String encrypted=encrypt(message);
        System.out.println("key is "+key+"\n"+encrypted);
        
    }
}