
public class ArrayBT {

    public static void changeArr(int a[], int index, int value) {
        if (index == a.length) {
            printArray(a);
            return;
        }
        a[index] = value;
        changeArr(a, index + 1, value + 1);
        a[index] = a[index] - 2;

    }

    private static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int a[] = new int[5];
        changeArr(a, 0, 1);
        printArray(a);
    }
}