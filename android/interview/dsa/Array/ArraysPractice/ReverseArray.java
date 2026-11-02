public class ReverseArray {


    // To reverse an array all i have to do is swapping
    // elements from fist index of array to last index of array
    // and increase index one by from left and descrease index one by one from right 
    // and moving towards center of array 

    // finally we will get reversed array

    // Procedure 
    // we require two pointers Let's say 
    // Left &Right 

    // Left start with 0 index of array and 
    // Right start with total lenght of array -1 which is last index of array 



   
    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 4, 5 };
        System.out.println("Before Reverse");
        for (int num : nums) {
            System.out.print(num + " ");
        }

        System.out.println();
        System.out.println("After Reverse");
        reverse(nums);
        for (int i : nums) {
            System.out.print(i+ " ");
        }
    }

    public static void reverse(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start <end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }
}