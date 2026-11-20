public class FirstLastPositionBS {

    public static int findBound(int nums[], int target, boolean isFirst) {
        int left = 0;
        int right = nums.length - 1;
        int bound = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                bound = mid;

                if (isFirst) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return bound;
    }

    public static int[] searchRange(int nums[], int target) {
        int first = findBound(nums, target, true);
        int last = findBound(nums, target, false);
        return new int[] { first, last };
    }

    public static void main(String[] args) {

        int nums[] = { 1, 2, 3, 4, 5, 6, 7, 9, 8, 10,4};
        int target = 4;

        int result[] = searchRange(nums, target);
        System.out.println("First & Last position: " + result[0] + " " + result[1]);

    }
}
