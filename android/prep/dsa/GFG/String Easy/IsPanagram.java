import java.util.HashSet;
import java.util.Set;

public class IsPanagram {

    public static boolean IsPanagramOrNot(String str) {

        Set<Character> letters = new HashSet<>();
        for (char currentChar : str.toCharArray()) {
            if (currentChar >= 'a' && currentChar <= 'z') {
                letters.add(currentChar);
            }
        }

        return letters.size() == 26;

    }

    public static void main(String[] args) {
        String str = "The quick brown fox jumps over the lazy dog";
        System.out.println(IsPanagramOrNot(str));
    }
}
