import java.util.*;;
public class LargestNum {

    public static int printLarNum(int arr[]) {
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
            if (arr[i]<smallest) {
                smallest = arr[i];
            }
        }
        System.out.println("smallest element is:"+smallest);
        return largest;
    }

    public static void main(String[] args) {
        int a[] = {2,3,4,6,7,8,9,10};
        int largElement = printLarNum(a);
        System.out.println("largest element is ->"+largElement);
    }
}
