import java.util.HashSet;

public class FirstRepeatingCharacter {

    public static String fRepeat(String str) {
        HashSet<Character> seen = new HashSet<>();

        for (char ch : str.toCharArray()) {
            if (seen.contains(ch)) {
                return Character.toString(ch);
            }
            seen.add(ch);
        }
        return "-1";

    }

    public static String firstRepeatingChar(String str) {

        for (int i = 0; i < str.length(); i++) {

            for (int j = 0; j < i; j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    return Character.toString(str.charAt(i));
                }
            }

        }
        return "-1";
    }

    public static void main(String[] args) {
        String str = "leaerning";
        System.out.println(fRepeat(str));

    }
}
