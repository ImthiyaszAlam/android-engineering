public class SumPair {

    // public static void findPairsArray(int arr[], int target) {
    // for (int i = 0; i < arr.length; i++) {
    // for (int j = i + 1; j < arr.length; j++) {
    // if (arr[i] + arr[j] == target) {
    // System.out.println("pair:" + arr[i] + " " + arr[j]);
    // }
    // }
    // }
    // }

    public static void findPairsArray(int arr[], int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            if (arr[low] + arr[high] > target) {
                high--;
            } else if (arr[low] + arr[high] < target) {
                low++;
            } else if (arr[low] + arr[high] == target) {
                System.out.println("pair;" + arr[low] + " " + arr[high]);
                low++;
                high--;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
        int target = 9;
        findPairsArray(arr, target);
    }
}
