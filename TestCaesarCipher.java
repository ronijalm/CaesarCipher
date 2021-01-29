import edu.duke.*;
public class TestCaesarCipher
{
   public int[] countLetters(String message){
        String alphabet="abcdefghijklmnopqrstuvwxqy";
        int[] counts=new int[26];
        for (int i=0;i<message.length();i++){
            char ch=Character.toLowerCase(message.charAt(i));
            int idx=alphabet.indexOf(ch);
            if (idx!=-1){
                counts[idx]+=1;
            }
        }
        return counts;
    }
    
   public int maxIndex(int[] vals){
        int maxDex=0;
        for (int i=0;i<vals.length;i++){
            if (vals[i]>vals[maxDex]){
                maxDex=i;
            }
        }
        //System.out.println(maxDex);
        return maxDex;
    }
   public void simpleTests(){
       FileResource fr=new FileResource();
       String message=fr.asString();
       CaesarCipher cc2=new CaesarCipher(15);
       System.out.println(cc2.encrypt(message));
       System.out.println(cc2.decrypt(message));
       System.out.println(breakCaesarCipher(message));
    }
    
   public String breakCaesarCipher(String input){
        int[] freqs=countLetters(input);
        int maxDex=maxIndex(freqs);
        int dkey=maxDex-4;
        if (maxDex<4){
            dkey=26-(4-maxDex);
        }
        CaesarCipher cc3=new CaesarCipher(26-dkey);
        return cc3.decrypt(input);
    }
 
}
    
