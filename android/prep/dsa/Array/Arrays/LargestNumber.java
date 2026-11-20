public class LargestNumber {
    public static void main(String[] args) {
        int numbers[] = {1,2,3,4,5,6,7,8,9,11,11,2,3,4,5};
        int largestNumber = Integer.MIN_VALUE;
        for(int i=0;i<numbers.length;i++){
            if (numbers[i]>largestNumber) {
                largestNumber = numbers[i];
            }
        }
        System.out.println("Largest Number is "+largestNumber);
    }
}
