public class MaxSubArray {

    public static void printMaxSubArraySum(int a[]) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            int start = i;
            for (int j = i; j < a.length; j++) {
                int end = j;
                currSum = 0;
                for (int k = start; k <= end; k++) {
                    currSum += a[k];
                }
                System.out.print(currSum + " ");
                if (maxSum < currSum) {
                    maxSum = currSum;
                }
            }
        }
        System.out.println("max sum: " + maxSum);

    }

    public static void main(String[] args) {
        int a[] = { 2, -4, 6, -8, 10 };
        printMaxSubArraySum(a);
    }
}
