public class LargestSmallest {
    public static void main(String[] args) {
        int a[] = {1,12,11,111,23,32,222,342,15};
        int smallestElement = a[0];
        int largestElement = a[0];

        for(int i=0; i<a.length-1;i++){
            if (smallestElement<a[i]) {
                largestElement = a[i];
            }else if (largestElement>a[i]) {
                smallestElement = a[i];
            }
        }
        System.out.println("largest element is: "+ largestElement);
        System.out.println("smallest element is: "+smallestElement);
    }
}
