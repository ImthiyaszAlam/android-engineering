public class BinarySearch {

    public static int binarySearch(int arr[], int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high-low) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (target < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr1[] = { 2, 4, 6, 8, 10, 11, 12 };
        int target = 8;
        System.out.println(binarySearch(arr1, target));

    }
}