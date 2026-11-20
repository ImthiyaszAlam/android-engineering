public class KadanesAlgo {

    public static void kadanes(int a[]){
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i=0;i<a.length;i++){
            currSum = currSum+=a[i];
            if (currSum<0) {
                currSum = 0;
            }
            maxSum = Math.max(currSum, maxSum);
        }
        System.out.println("max subarray sum : "+maxSum);
    }

    public static void main(String[] args) {
        int a[] = { 1,-2,6,-1,3 };
        kadanes(a);
        
    }
}
