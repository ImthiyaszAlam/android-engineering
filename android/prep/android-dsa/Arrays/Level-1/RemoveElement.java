public class RemoveElement {

    public static int removeElement(int nums[], int value) {

        int write = 0;

        for (int read = 0; read < nums.length; read++) {
            if (nums[read] != value) {
                nums[write] = nums[read];
                write++;
            }
        }
        return write;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 2, 3, 4 };
        int k = removeElement(nums, 2);
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
