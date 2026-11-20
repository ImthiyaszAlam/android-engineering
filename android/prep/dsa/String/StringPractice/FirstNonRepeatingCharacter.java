import java.util.HashMap;

public class FirstNonRepeatingCharacter {

    public static Character findFirstNonRepeatingChar(String str) {
        HashMap<Character, Integer> charCount = new HashMap<>();

        for (char ch : str.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }

        for (char c : str.toCharArray()) {
            if (charCount.get(c) == 1) {
                return c;
            }
        }
        return null;
    }

    public static void main(String[] args) {

        String str = "alam";
        Character result = findFirstNonRepeatingChar(str);

        if (result != null) {
            System.out.println("First non-repeating character: " + result);
        } else {
            System.out.println("No non-repeating character found");
        }

    }
}
