public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 2, 3, 4, 4, 5 }; // Sorted array

        int j = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }

        int newLength = j + 1;
        System.out.println("Array after removing duplicates:");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
