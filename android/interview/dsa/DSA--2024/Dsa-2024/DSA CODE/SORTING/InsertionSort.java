public class InsertionSort {

    public static void insertionSort(int a[]) {
        for (int i = 1; i < a.length; i++) {
            int currentElement = a[i]; // Store the value of the current element
            int previousElement = i - 1;

            // Shift elements of a[0..i-1] that are greater than currentElement to one position ahead
            while (previousElement >= 0 && a[previousElement] > currentElement) {
                a[previousElement + 1] = a[previousElement];
                previousElement--;
            }
            
            // Insert the current element into its correct position
            a[previousElement + 1] = currentElement;
        }
    }

    public static void printArray(int a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println(); // For better output formatting
    }

    public static void main(String[] args) {
        int a[] = {3, 1, 5, 4, 2};
        insertionSort(a);
        printArray(a);
    }
}
