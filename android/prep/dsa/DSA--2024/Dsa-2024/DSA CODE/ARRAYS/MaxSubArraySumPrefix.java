public class MaxSubArraySumPrefix {
    public static void main(String[] args) {
        int a[] = { 1, -2, 6, -1, 3 };
        int prefix[] = new int[a.length];
        prefix[0] = a[0];
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + a[i];
        }

        for (int i = 0; i < a.length; i++) {

            for (int j = i + 1; j < a.length; j++) {

                currentSum = i ==0?prefix[j] : prefix[j] - prefix[i - 1];
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }
            }
        }
        System.out.println("max sum is: " + maxSum);
    }
}
