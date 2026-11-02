public class TwoSum {

    public static int[] twoSum(int nums[], int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { nums[i], nums[j] };
                }
            }
        }

        return new int[] { -1, -1 };

    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 4, 5, 6, 7 };
        int target = 7;
        int[] result = twoSum(nums, target);
        System.out.println(result[0] + "  " + result[1]);
    }
}
