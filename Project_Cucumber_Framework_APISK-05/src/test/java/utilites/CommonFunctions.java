package utilites;
import java.util.Random;

public class CommonFunctions {
    // Method to generate a random string
    public static String generateRandomString(int min, int max) {
        // Define the characters to use in the string
        String signsSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        char[] chars=signsSet.toCharArray();
        String randString= "";
        Random rand = new Random();
        int length=rand.nextInt((max-min) +1)+min;
        while(length>0)
        {
        	randString +=chars[rand.nextInt(chars.length)];
        	length--;
        }
        return randString;
        
       
        }

    public static String generateRandomEmail() {
    	String str1=generateRandomString(3,15);
    	String str2=generateRandomString(3,15);
    	String str3=generateRandomString(3,15);
    	return String.format("%s.%s@%s.com", str1,str2,str3);
    	
    	
        
    }
}
