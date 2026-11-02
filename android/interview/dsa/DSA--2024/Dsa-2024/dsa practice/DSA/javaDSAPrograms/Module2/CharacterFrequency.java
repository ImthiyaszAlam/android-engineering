import java.util.Map;
import java.util.TreeMap;

public class CharacterFrequency {

    private void getCount(String str) {
        int wordCount = 0, vowelCount = 0, uppercaseCount = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            switch (ch) {
                case ' ':
                case '.':
                    wordCount++;
                    break;
            }

            switch (ch) {
                case 'A':
                case 'E':
                case 'I':
                case 'O':
                case 'U':
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    vowelCount++;
                    break;
            }

            if (Character.isUpperCase(ch)) {
                uppercaseCount++;
            }
        }
        System.out.println("WordCount=" + wordCount);
        System.out.println("VowelCount=" + vowelCount);
        System.out.println("UppercaseCount=" + uppercaseCount);
    }

    private void getFrequency(String str) {
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println("Character=" + entry.getKey());
            System.out.println("Frequency=" + entry.getValue());
        }
    }

    public static void main(String[] args) {
        String str = "I am Learning Java DSA Coding";

        CharacterFrequency cf = new CharacterFrequency();
        cf.getCount(str);
        cf.getFrequency(str);
    }
}

