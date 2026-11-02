public class MajorityElement {

    public static int majorityElement(int nums[]) {

        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {

            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }

            if (count > n / 2) {
                return nums[i];
            }
        }
        return -1;

    }

    public static int majorityElementOptimal(int nums[]) {

        // [2,2,1,1,1,2,2]

        int candidate = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];

                // 2,2,1,1,1,2,2
                // 1,2,1,0,1,0,1 so finally 2 survived with score : 1
            }

            if (candidate == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {

        int nums[] = { 2, 2, 1, 1, 1, 2, 2, 1, 1, 1, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, };
        int element = majorityElementOptimal(nums);
        System.out.println(element);
    }
}
