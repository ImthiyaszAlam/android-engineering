import java.util.HashMap;

public class ValidAnagram {

    public static boolean validAnagram(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char currentChar = s1.charAt(i);

            map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);
        }

        for (int i = 0; i < s2.length(); i++) {
            char currentKey = s2.charAt(i);
            if (!map.containsKey(currentKey)) {
                return false;
            }

            map.put(currentKey, map.get(currentKey) - 1);

            if (map.get(currentKey) < 0) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {

        String s1 = "anagram";
        String s2 = "nagarm";

        System.out.println(validAnagram(s1, s2));

    }
}
