import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {

        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);

        int count = 0;
        int currentSum = 0;

        for (int num : nums) {
            currentSum += num;

            if (prefixSumCount.containsKey(currentSum - k)) {
                count += prefixSumCount.get(currentSum - k);

            }

            prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3 };

        SubarraySumEqualsK subarraySumEqualsK = new SubarraySumEqualsK();

        System.out.println(subarraySumEqualsK.subarraySum(nums, 3));
    }
}
