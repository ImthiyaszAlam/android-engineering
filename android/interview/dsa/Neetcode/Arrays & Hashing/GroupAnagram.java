import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagram {

    public static List<List<String>> groupAnagram(String str[]) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < str.length ; i++) {
            String currentWord = str[i];
            char [] currentWordArray = currentWord.toCharArray();
            Arrays.sort(currentWordArray);

            String sortedKeyString = new String(currentWordArray);

            map.putIfAbsent(sortedKeyString, new ArrayList<>());
            map.get(sortedKeyString).add(currentWord);

        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String str[] = { "eat", "tea", "tan", "ate", "nat", "bat" };
      List<List<String>>result=  groupAnagram(str);
      System.out.println(result);
    }
}
