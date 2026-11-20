public class MoveZeroes {

    public static void moveAllZeroes(int nums[]) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        break;
                    }

                }
            }
        }
    }

    public static void moveZeroesOptimalTP(int nums[]) {
        int write = 0;

        for (int read = 0; read < nums.length; read++) {
            if (nums[read] != 0) {
                int temp = nums[read];
                nums[read] = nums[write];
                nums[write] = temp;
                write++;
            }
        }
    }

    public static void moveZeroesToFront(int nums[]) {
        int write = nums.length - 1;

        for (int read = nums.length - 1; read >= 0; read--) {
            if (nums[read] != 0) {
                int temp = nums[read];
                nums[read] = nums[write];
                nums[write] = temp;
                write--;
            }
        }
    }

    public static void main(String[] args) {
        int nums[] = { 1, 0, 1, 0, 1, 1 };
        // moveAllZeroes(nums);
        // moveZeroesOptimalTP(nums);
        moveZeroesToFront(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }

    }

}
