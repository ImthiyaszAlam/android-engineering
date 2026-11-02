import java.util.Arrays;
import java.util.Scanner;

public class MaximumElement {

    public static void findMaximumElement(int a[]) {
        int maxElement = a[0];
        for (int i = 0; i < a.length; i++) {
            if (maxElement < a[i]) {
                maxElement = a[i];
            }
        }
        System.out.println("maximum element is: " + maxElement);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of an array");
        int arraySize = sc.nextInt();
        int arr[] = new int[arraySize];
        System.out.println("Enter array elements");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        findMaximumElement(arr);
        System.out.println(Arrays.toString(arr));
    }
}
