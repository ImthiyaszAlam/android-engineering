import java.util.HashMap;
import java.util.Map;

public class FindUnique {

    public static int findUnique(int[] arr) {


        Map<Integer,Integer> freq = new HashMap<>();
                int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                freq.put(i, freq.getOrDefault(freq, 1));
                
                }
            }
        }
        return arr[i];
    }

    public static void main(String[] args) {

    }
}
