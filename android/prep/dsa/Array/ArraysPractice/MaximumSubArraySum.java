public class MaximumSubArraySum {

    public static int findMaxSubArraySum(int arr[]){

        //Maintain two variables
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int num:arr){
            currentSum+=num;
            maxSum = Math.max(maxSum, currentSum);


            // if current sum is negative ,better reset to 0
            if (currentSum<0) {
                currentSum=0;
            }
         
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,-3,4,-5,5,-7};
        System.out.println(findMaxSubArraySum(arr));
    }
}