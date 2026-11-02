public class SecondLargest {

    public static int secondLargestNum(int nums[]) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > largest) {
                secondLargest = largest;
                largest = nums[i];

            } else if (nums[i] > secondLargest && nums[i] != largest) {
                secondLargest = nums[i];
            }
        }

        if (secondLargest == Integer.MIN_VALUE) {
            throw new IllegalArgumentException(
                    "No second largest distinct number");
        }
        return secondLargest;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 4, 5, 6, 7, 8, 1, 11, 20, 16 };
        int result = secondLargestNum(nums);
        System.out.println(result);
    }
}
