import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

    public static int lengthOfLongestSubstring(String str) {

        int left = 0;
        int maxLength = 0;

        Set<Character> seen = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            while (seen.contains(str.charAt(i))) {
                seen.remove(str.charAt(left));
                left++;
            }
            seen.add(str.charAt(i));

            int longestSubString = i - left + 1;
            maxLength = Math.max(maxLength, longestSubString);
        }

        return maxLength;

    }

    public static void main(String[] args) {

        String str = " ";
        System.out.println(lengthOfLongestSubstring(str));
    }
}