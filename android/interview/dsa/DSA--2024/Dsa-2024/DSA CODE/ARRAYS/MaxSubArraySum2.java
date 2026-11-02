public class MaxSubArraySum2 {

    public static void printSubArraySum(int a[]) {
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int prefixSum[] = new int[a.length];

        prefixSum[0] = a[0];
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + a[i];
        }
        for (int i = 0; i < a.length; i++) {
            int start = i;
            for (int j = i; j < a.length; j++) {
                int end = j;
                currentSum = start == 0 ? prefixSum[end] : prefixSum[end] - prefixSum[start - 1];
                if (maxSum < currentSum) {
                    maxSum = currentSum;
                }
            }

        }
        System.out.println("max sum is: " + maxSum);
    }

    public static void main(String[] args) {
        int a[] = { 1, -2, 6, -1, 3 };
        printSubArraySum(a);
    }
}
