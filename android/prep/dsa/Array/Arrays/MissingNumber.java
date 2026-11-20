public class MissingNumber {


    public static int findMissingNumber(int nums[]){
        int actualSum = 0;
        int totalNumber = nums.length;
        int totalSum = totalNumber *(totalNumber+1) /2;
        for(int num:nums){
            actualSum+=num;
        }

        return totalSum-actualSum;
    }
    public static void main(String[] args) {
        int arr[] = {5,3,2,1,0};
        System.out.println(findMissingNumber(arr));

    }
}
