import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class NoRepWord {
    public static void main(String[] args) {
        String str = "aabbcdde";
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char ch : str.toCharArray()) {
            map.put(ch, map.containsKey(ch) ? map.get(ch) + 1 : 1);
        }
        for (Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println(entry.getKey());
                return;
            }
        }
        throw new RuntimeException("not found any char");
    }

}
