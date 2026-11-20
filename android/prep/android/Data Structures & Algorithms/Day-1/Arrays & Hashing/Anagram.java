import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Anagram {

    public static List<List<String>> groupAnagram(String str[]) {

        HashMap<String, List<String>> map = new HashMap();

        for (int i = 0; i < str.length; i++) {
            String currentWord = str[i];
            char[] chars = currentWord.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(currentWord);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {

        String [] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagram(str));

    }
}
