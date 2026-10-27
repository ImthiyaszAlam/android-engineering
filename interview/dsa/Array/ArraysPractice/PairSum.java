import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PairSum {
    public static void main(String[] args) {

        int nums[] = { 2, 3, 4, 5, 6, 7, 8, 9 };
        int target = 9;
        List<int[]> pairs = getPairs(nums, target);

        if (pairs.isEmpty()) {
            System.out.println("No pairs found");
        } else {
            System.out.println("Pairs that sum to " + target + " is ");
            for (int[] pair : pairs) {
                System.out.println(Arrays.toString(pair));
            }
        }

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