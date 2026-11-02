public class MissingNumber {


    public int missingNumberMethod(int [] numberArray){

        int size = numberArray.length;
        int expextedSum = (size*(size-1))/2;
        int actualSum = 0;

        for(int i=0; i<numberArray.length; i++){
            actualSum = actualSum + numberArray[i];
        }
        return expextedSum -  actualSum;
    }
    public static void main(String[] args) {
        MissingNumber missingNumber = new MissingNumber();
        int [] arr1 = {1,3,4,5,6,7,8,9};
        int missNumber = missingNumber.missingNumberMethod(arr1);
        System.out.println(missNumber);
    }
}
