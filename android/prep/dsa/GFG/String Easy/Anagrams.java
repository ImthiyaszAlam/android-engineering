import java.util.Arrays;

public class Anagrams {

    public static boolean isAnagram(String s1, String s2) {

        char s1Char[] = s1.toCharArray();
        char s2Char[] = s2.toCharArray();

        Arrays.sort(s1Char);
        Arrays.sort(s2Char);

        return Arrays.equals(s1Char, s2Char);

    }

    public static void main(String[] args) {
        String s1 = "geeks";
        String s2 = "seekg";
        System.out.println(isAnagram(s1, s2));
    }
}
