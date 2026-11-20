public class MissingNumberArray {
    public static void main(String[] args) {
        int arr[]={1,2,4,5,5,6,7,8,9};
        int sum1 = 0;


        for(int i=0; i<arr.length;i++){
            sum1 = sum1+arr[i];
        }
        System.out.println("Sum of elements in arry:"+sum1);

        int sum2 = 0;
        for(int i=1; i<=5;i++){
            sum2 = sum2+i;
        }

        System.out.println("Sum of range of elements in arry:"+sum2);
        int missingNumber  = sum1-sum2;
        System.out.println("Missing Number is:"+missingNumber);
    }
}
