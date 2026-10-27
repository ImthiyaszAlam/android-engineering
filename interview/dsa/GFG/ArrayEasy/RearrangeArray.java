public class RearrangeArray {

    public static void rearrange(int arr[]) {

        for (int i = 1; i < arr.length; i++) {
            if (i % 2 == 1) {
                if (arr[i] < arr[i - 1]) {
                    swap(arr, i, i - 1);
                }
            } else {
                if (arr[i] >= arr[i - 1]) {
                    swap(arr, i, i - 1);
                }
            }
        }

    }

    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 2, 1 };
        rearrange(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
