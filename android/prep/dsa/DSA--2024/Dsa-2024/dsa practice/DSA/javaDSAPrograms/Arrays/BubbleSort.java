
public class BubbleSort {

    public static void bubbleSortMethod(int a[]) {
        if (a.length == 0 || a.length == 1) {
            return;
        }

        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int a[] = {10, 12, 20, 9, 7, 14, 19};
        bubbleSortMethod(a);
        
        // Print sorted array
        for (int i=0;i<a.length-1;i++) {
            System.out.print(a[i] + " ");
        }
    }
}