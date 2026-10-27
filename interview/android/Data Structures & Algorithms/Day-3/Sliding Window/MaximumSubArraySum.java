public class MaximumSubArraySum {

    public static int maxSum(int nums[], int k) {

        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {

            int currentSum = 0;
            for (int j = i; j < +k; j++) {
                currentSum += nums[j];
            }

            Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {

    }
}
