import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class LetterCount {
    public static void main(String[] args) {
        String str = "pineapple";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            Integer count = map.get(ch);
            if (count != null) {
                map.put(ch, new Integer(count + 1));
            } else {
                map.put(ch, 1);
            }
        }

        Set<Entry<Character,Integer>> set = map.entrySet();
        List<Entry<Character,Integer>> list = new ArrayList<>();
        Collections.sort(list,new Comparator<Map<Character,Integer>.Entry<Character,Integer>>() {
            
        });
    }
}
