import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LongestSubString {
    public static void main(String[] args) {
        String str = "abaccba";
        String longestSubString = null;
        int longestSubStringLength = 0;

        Map<Character,Integer>map = new LinkedHashMap<Character,Integer>();
        char[] arr = str.toCharArray();
        for(int i=0;i<arr.length;i++){
            char ch = arr[i];
            if (!map.containsKey(ch)) {
                map.put(ch, i);
            }else{
                i = map.get(ch);
                map.clear();
            }
            if (map.size()>longestSubStringLength) {
                longestSubStringLength = map.size();
                longestSubString = map.keySet().toString();
            }
        }
        System.out.println(longestSubString);
        System.out.println(longestSubStringLength);
    }
}
