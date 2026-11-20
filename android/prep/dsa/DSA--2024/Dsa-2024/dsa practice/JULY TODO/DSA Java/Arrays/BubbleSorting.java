import java.util.Arrays;
import java.util.Scanner;

public class BubbleSorting {

    public static void bubbleSorting(int a[]) {
        // int a[] = {4,3,5,1,7,8,2};
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] < a[j + 1]) {
                    int temp = a[j + 1];
                    a[j + 1] = a[i];
                    a[i] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of an array");
        int size = sc.nextInt();
        int arr[] = new int[size];
        System.out.println("Enter array elements");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        bubbleSorting(arr);

    }
}
