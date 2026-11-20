import java.util.Arrays;

public class BubbleSort {

    public static void bubbleSort(int a[]) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] < a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Array before sorting");
        int a[] = { 1, 2,55, 33, 3, 44, 45, 4, 56, 43, 56 };
        
        System.out.println(Arrays.toString(a));
        System.out.println("array after sorting");
        bubbleSort(a);
        System.out.println(Arrays.toString(a)); 

    }
}
