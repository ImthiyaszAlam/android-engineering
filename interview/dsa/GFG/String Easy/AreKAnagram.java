import java.util.HashMap;
import java.util.Map;

public class AreKAnagram {

    public static boolean isKAnagram(String s1, String s2, int k) {

        if (s1.length() != s2.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            if (map.getOrDefault(ch, 0) > 0) {
                map.put(ch, map.get(ch) - 1);
            }
        }

        int count = 0;
        for (char ch : map.keySet()) {
            count += map.get(ch);
        }

        if (count > k) {
            return false;
        } else {
            return true;
        }

    }

    public static void main(String[] args) {
        String s1 = "geek";
        String s2 = "leet";
        int k = 1;
        if (isKAnagram(s1, s2, k)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
