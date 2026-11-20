public class CountingSort {

    public static void countingSort(int a[]) {
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < a.length - 1; i++) {
            largest = Math.max(largest, a[i]);
        }
        int countLargest[] = new int[largest + 1];
        for (int i = 0; i < a.length; i++) {
            countLargest[a[i]]++;
        }

        int j = 0;
        for (int i = 0; i < countLargest.length; i++) {
            while (countLargest[i] > 0) {
                a[j] = i;
                j++;
                countLargest[i]--;

            }
        }
    }

    public static void printArray(int a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int a[] = { 3, 1, 5, 4, 2 };
        countingSort(a);
        printArray(a);
    }
}
