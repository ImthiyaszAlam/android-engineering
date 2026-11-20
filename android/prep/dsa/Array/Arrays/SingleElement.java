public class SingleElement {

    public static void findSingleElement(int arr[]) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid % 2 == 1) {
                mid--;
            }

            if (arr[mid] == arr[mid + 1]) {
                left = mid + 2;
            } else {
                right = mid;
            }
        }
        // return arr[left];
        System.out.println(arr[left]);
    }

    public static void main(String[] args) {
        int nums[] = { 1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6 };
        findSingleElement(nums);

    }
}