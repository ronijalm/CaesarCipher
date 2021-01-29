import edu.duke.*;

/**
 * Write a description of class TestCaesarCipherTwo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TestCaesarCipherTwo
{
    public String halfOfString(String message, int start){
        StringBuilder newStr=new StringBuilder("");
        for (int i=start;i<message.length();i+=2){
            newStr=newStr.append(message.charAt(i));
        }
        return newStr.toString();
    }
    
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
        CaesarCipherTwo cc=new CaesarCipherTwo(14,24);
        System.out.println(cc.encrypt(message));
        System.out.println(cc.decrypt(message));
        System.out.println(breakCaesarCipher(message));
    }
    
   public String breakCaesarCipher(String input){
       String firstHalf=halfOfString(input, 0);
       String secondHalf=halfOfString(input, 1);
       int [] counts1=countLetters(firstHalf);
       int [] counts2=countLetters(secondHalf);
       int idx1=maxIndex(counts1);
       int idx2=maxIndex(counts2);
       int dkey1=idx1-4;
       if (idx1<4){
            dkey1=26-(4-idx1);
       }
       int dkey2=idx2-4;
       if (idx2<4){
            dkey2=26-(4-idx2);
       }
       CaesarCipherTwo ccc=new CaesarCipherTwo(26-dkey1, 26-dkey2);
       System.out.println(dkey1);
       System.out.println(dkey2);
       return ccc.encrypt(input);
   }
}
