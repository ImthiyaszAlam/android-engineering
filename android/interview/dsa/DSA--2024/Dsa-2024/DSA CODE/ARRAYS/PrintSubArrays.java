public class PrintSubArrays {
    public static void main(String[] args) {
        int arr[] = { 2, 4, 6, 8, 10 };
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
    
            for (int j = i; j < arr.length; j++) {
                currentSum = 0;
                for (int k = i; k <= j; k++) {
                    System.out.println(arr[k]+" ");
                    currentSum+=arr[k];
                }
                System.out.println("current sum is : "+currentSum);
                if (maxSum<currentSum) {
                    maxSum = currentSum;
                }
            }
        }
        System.out.println("maximum sum is "+maxSum);
    }
}
