import java.util.Arrays;
import java.util.HashMap;

public class AnagramSubstring {

    static void substring(String str) {
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                char[] valC = str.substring(i, j + 1).toCharArray();
                Arrays.sort(valC);
                String value = new String(valC);
                if (map.containsKey(value)) {
                    map.put(value, map.get(value) + 1);
                } else {
                    map.put(value, 1);
                }
            }
        }
        int anagramCount = 0;
        for (String key : map.keySet()) {
            int n = map.get(key);
            anagramCount += (n * (n - 1)) / 2;
            ;
        }
        System.out.println(anagramCount);
    }

    public static void main(String[] args) {
        String str = "alam";
        substring(str);
    }
}
