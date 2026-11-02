public class MissingNumber {

    public static int findMissingNumber(int arr[]){
        int n = arr.length;
        int actualSum = 0;
        int expectedSum = n* (n+1)/2;

        for(int num:arr){
            actualSum+=num;
        }

        int missingNumber = expectedSum-actualSum;
        return missingNumber;
    }
    public static void main(String[] args) {
        int arr[] = {0,1,2,3,5};
        System.out.println(findMissingNumber(arr));
    }
}
