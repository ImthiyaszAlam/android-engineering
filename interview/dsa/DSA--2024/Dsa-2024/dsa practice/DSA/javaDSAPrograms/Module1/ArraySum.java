public class ArraySum {
    public static void main(String[] args) {
        int arr1[]={10,10};
        int arraySum = 0;
        for(int i=0;i<arr1.length;i++){
            arraySum = arraySum+arr1[i];
        }

        System.out.println( "Sum is:"+ arraySum);
    }
}
