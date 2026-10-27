public class KadaneAlgorithm {


    public int maxSumSubArray(int a[]){
        int currentSum = 0;
        int maxSum = 0;

        for (int i = 0; i < a.length; i++) {
            currentSum = currentSum + a[i];

            if (maxSum < currentSum) {
                maxSum = currentSum;
            }
            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {

        KadaneAlgorithm kadaneAlgorithm = new KadaneAlgorithm();
        int a [] = {1,2,3,-4,5,6,-2,60};
        int avMaxSum = kadaneAlgorithm.maxSumSubArray(a);
        System.out.println(avMaxSum);
    }
}
