import java.util.Arrays;

public class Anagram {

    public static boolean isAnagram(String str1, String str2) {

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        if (str1.length() != str2.length()) {
            return false;
        }

        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();

        Arrays.sort(char1);
        Arrays.sort(char2);

        return Arrays.equals(char1, char2);
    }

    public static void main(String[] args) {
        String str1 = "mala";
        String str2 = "Alam";
        boolean result = isAnagram(str1, str2);
        System.out.println(result);
    }
}
