import java.util.HashMap;
import java.util.Map;

public class WordOccurences {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        String s1 = "learning java program";
        int count = 1;
        String str[] = s1.split(" ");
        for (int i = 0; i < s1.length(); i++) {
            if (!map.containsKey(str[i])) {
                map.put(str[i], count);
            } else {
                map.put(str[i], map.get(str[i])+1);
            }
        }

        for(String s:map.keySet()){
            System.out.println(s+" "+map.get(s));
        }
    }
}
