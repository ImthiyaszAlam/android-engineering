import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PairSum {
    public static void main(String[] args) {

    }

    public static List<int[]> getPairs(int arr[], int target) {

        Set<Integer> seen = new HashSet<>();
        List<int[]> pairs = new ArrayList<>();

        for (int num : arr) {
            int complement = target - num;
            if (seen.contains(complement)) {
                pairs.add(new int[] { num, complement });
            }
            seen.add(num);
        }
        return pairs;
    }
}