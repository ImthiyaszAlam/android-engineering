public class FirstLastPosition {

    public static int findFirstLastPosition(int arr[], int target, boolean firstHand) {
        int start = 0;
        int end = arr.length - 1;
        int result = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                result = mid;
                if (firstHand) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;

    }

    public static int[] searchRange(int nums[], int target) {
        int first = findFirstLastPosition(nums, target, true);
        int last = findFirstLastPosition(nums, target, false);
        return new int[] { first, last };
    }

    public static void main(String[] args) {
        int nums[] = { 5, 7, 7, 8, 8,8, 10 };
        int target = 8;
        int result[] = searchRange(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }
}
