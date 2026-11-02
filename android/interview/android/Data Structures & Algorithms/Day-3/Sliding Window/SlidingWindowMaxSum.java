public class SlidingWindowMaxSum {

    public static int masXumSlidingWindow(int nums[], int k) {

        int maxSum = 0;
        int currentWindowSum = 0;

        for (int i = 0; i < k; i++) {
            currentWindowSum += nums[i];
        }

        maxSum = currentWindowSum;

        for (int i = k; i < nums.length; i++) {
            currentWindowSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, currentWindowSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 4, 2, 10, 23, 3, 1, 0, 20 };
        int k = 4;

        System.out.println(masXumSlidingWindow(nums, k));
        ;

    }
}
