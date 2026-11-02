import java.util.Arrays;

/**
 * Anagram
 */
public class Anagram {

    public static void main(String[] args) {
        String str1 = "anna";
        String str2 = "anna";

        char[] charStr1 = str1.toCharArray();
        char[] charStr2= str2.toCharArray();
        Arrays.sort(charStr1);
        Arrays.sort(charStr2);

        if (Arrays.equals(charStr1, charStr2)) {
            System.out.println(" this is anagram");
        }else{
            System.out.println("this is not an anagram");
        }
    }
}