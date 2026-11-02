import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static int minWindow(String s, String t) {

        Map<Character, Integer> tCount = new HashMap<>();
        for (char currentElement : t.toCharArray()) {
            if (tCount.containsKey(tCount.getOrDefault(tCount, 0) + 1)) {

            }

            tCount.put(currentElement, tCount.getOrDefault(currentElement, tCount.getOrDefault(tCount, 0) + 1));
        }

        // Sliding Window

        int minLeft = 0;
        int minLen = 0;
        Map<Character, Integer> sCount = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {

            if (sCount.containsKey(s.charAt(right), sCount.getOrDefault(s.charAt(right), 0) + 1)) {

            }

            sCount.put(s.charAt(right), sCount.getOrDefault(s.charAt(right), 0) + 1);
        }
    }

    public static void main(String[] args) {

    }
}
