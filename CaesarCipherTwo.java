import edu.duke.*;
/**
 * Write a description of class CaesarCipherTwo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CaesarCipherTwo
{   
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int mainKey1;
    private int mainKey2;
    public CaesarCipherTwo(int key1, int key2){
        alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet1=alphabet.substring(key1)+ alphabet.substring(0,key1);
        shiftedAlphabet2=alphabet.substring(key2)+ alphabet.substring(0,key2);
        mainKey1=key1;
        mainKey2=key2;
    }
    public String encrypt(String input){
        StringBuilder encrypted=new StringBuilder(input);
        
        for (int i=0; i<encrypted.length();i+=2){
            char currChar=encrypted.charAt(i);
            int idx=alphabet.indexOf(Character.toUpperCase(currChar));
            if (idx!=-1){
                char newChar=shiftedAlphabet1.charAt(idx);
                if (Character.isUpperCase(currChar)==true){
                    encrypted.setCharAt(i,newChar);
                }
                else{
                    encrypted.setCharAt(i,Character.toLowerCase(newChar));
                }
            }
        }
        for (int i=1; i<encrypted.length();i+=2){
            char currChar=encrypted.charAt(i);
            int idx=alphabet.indexOf(Character.toUpperCase(currChar));
            if (idx!=-1){
                char newChar=shiftedAlphabet2.charAt(idx);
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
    
    public void testEncryptTwoKeys(){
        //System.out.println("Czojq Ivdzle should be the result");
        //System.out.println(encryptTwoKeys("First Legion",23,17));
        //System.out.println(encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!",8,21));
    }
    
    public String decrypt(String input){
        CaesarCipherTwo cc=new CaesarCipherTwo(26-mainKey1, 26-mainKey2);
        return cc.encrypt(input);
    }
  
    
}


