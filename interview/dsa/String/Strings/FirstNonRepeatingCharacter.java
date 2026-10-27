import java.util.HashMap;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {

        String str = "swiss";
        Character result = findFirstNonRepeatingChar(str);
        if (result != null) {
            System.out.println("First Non-Repeating Character: " + result);
        } else {
            System.out.println("No Non-Repeating Character Found");
        }

    }

    public static Character findFirstNonRepeatingChar(String str) {
        HashMap<Character, Integer> charCount = new HashMap<>();

        for (char c : str.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        for (char c : str.toCharArray()) {
            if (charCount.get(c) == 1) {
                return c;
            }
        }

        return null;

    }
}
