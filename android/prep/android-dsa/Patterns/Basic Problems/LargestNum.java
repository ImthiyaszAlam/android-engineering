public class LargestNum {

    public static int largestNum(int nums[]) {
        int max = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {

        int nums[] = { 10, 20, 100, 30, 15, 45, 35 };
        int result = largestNum(nums);
        System.out.println(result);

    }
}
