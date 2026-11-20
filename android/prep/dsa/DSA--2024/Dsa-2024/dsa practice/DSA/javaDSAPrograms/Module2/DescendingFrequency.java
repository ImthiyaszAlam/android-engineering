import java.util.HashMap;

public class DescendingFrequency {
    public static void main(String[] args) {
        String str = "Malayalam";
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            Integer hashValue = hashMap.get(ch);
            if (hashValue != null) {
                hashMap.put(ch, hashValue + 1);
            } else {
                hashMap.put(ch, 1);
            }
        }

        System.out.println(str);
        System.out.println(hashMap);
    }
}

