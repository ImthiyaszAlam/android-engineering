import java.util.HashMap;
import java.util.Map;

public class DuplicateElem {
    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 4, 5, 3, 8 };
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(a[i])) {
                map.put(a[i], map.get(a[i]) + 1);
            } else {
                map.put(a[i], 1);
            }
        }

        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            if (entry.getValue()==1) {
                System.out.println(entry.getKey()+" ");
            }
        }
    }

}
