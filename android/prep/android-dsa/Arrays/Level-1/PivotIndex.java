public class PivotIndex {

    public static int pivotElement(int nums[]) {

        for (int i = 0; i < nums.length; i++) {

            int left = 0;
            int right = 0;

            for (int j = 0; j < i; j++) {
                left += nums[j];
            }

            for (int j = i + 1; j < nums.length; j++) {
                right += nums[j];
            }

            if (left == right) {
                return i;
            }

        }

        return -1;
    }

    public static int pivotIndexOptimal(int nums[]) {

        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;

        for (int i = 0; i < nums.length; i++) {

            leftSum += nums[i];
            int rightSum = totalSum - leftSum - nums[i];

            if (leftSum == rightSum) {
                System.out.println("Element is " + nums[i]);
                return i;

            }

        }

        return -1;
    }

    public static void main(String[] args) {

        int nums[] = { 1, 2, 3, 3, 2, 4 };
        int pivotIndex = pivotIndexOptimal(nums);
        System.out.println("pivot Index is : " + pivotIndex);
    }
}
