public class MaximumSubArraySum {

    public static int findMaxSubArraySum(int arr[]) {
        int currentSum = 0;
        int maxSumSoFar = Integer.MIN_VALUE;

        for (int currentElement : arr) {
            currentSum += currentElement;
            maxSumSoFar = Math.max(maxSumSoFar, currentSum);

            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return maxSumSoFar;
    }

    public static void main(String[] args) {

        int arr[] ={-2, 1, -3, 4, -1, 2, 1, -5, 4}; ;
        System.out.println(findMaxSubArraySum(arr));
    }
}