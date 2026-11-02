import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PairSum {




    
    public static void main(String[] args) {
        int nums[] = { 2, 4, 3, 5, 7, 8, 1 };
        int target = 9;

        List<int[]> result = findPairs(nums, target);
        System.out.println("Total Pairs: " + result.size());
        if (result.isEmpty()) {
            System.out.println("No pairs found");
        } else {
            System.out.println("Pairs that sum to " + "target: ");
            for (int[] pair : result) {
                System.out.println(Arrays.toString(pair));
            }
        }

    }

    public static List<int[]> findPairs(int arr[], int target) {
        Set<Integer> seen = new HashSet<>();
        List<int[]> pairs = new ArrayList<>();

        for (int num : arr) {
            int complement = target - num;
            if (seen.contains(complement)) {
                pairs.add(new int[] { complement, num });
            }
            seen.add(num);
        }

        return pairs;
    }
}
