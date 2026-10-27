import java.util.HashMap;
import java.util.Map;

public class LetterOccurence {
    public static void main(String[] args) {

        Map<Character, Integer> map = new HashMap<>();
        String str = "java program";
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                int count = map.get(ch);
                map.put(ch, count + 1);
            }
        }
        System.out.println(map);
    }
}
