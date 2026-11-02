public class SortedArray {

    static boolean isSortedHelper(int arr[], int n) {
        if (n == 0 || n == 1) {
            return true;
        }
        return arr[n - 1] >= arr[n - 2] && isSortedHelper(arr, n - 1);

    }

    static boolean isSorted(int arr[], int length) {
        return isSortedHelper(arr, length);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3,7, 4, 5, 6 };
        int n = arr.length;
        System.out.println(isSorted(arr, n));

    }
}
