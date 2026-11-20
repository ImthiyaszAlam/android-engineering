public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int arr1[] = { 3, 4, 5, 1, 2 };
        System.out.println(findMinimum(arr1));
    }

    public static int findMinimum(int arr[]) {
        int start = 0;
        int end = arr.length - 1;
        while (start <end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return arr[start];
    }
}
