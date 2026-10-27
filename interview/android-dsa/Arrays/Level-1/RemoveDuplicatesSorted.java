import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesSorted {

    public static Set<Integer> removeDuplicates(int nums[]) {

        Set<Integer> seen = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (seen.contains(nums[i])) {
                continue;
            } else {
                seen.add(nums[i]);
            }
        }
        return seen;

    }

    public static int removeDuplicatesOptimal(int nums[]) {
        int write = 1;

        for (int read = 1; read < nums.length; read++) {
            if (nums[read] != nums[read - 1]) {
                nums[write] = nums[read];
                write++;
            }
        }
        return write;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6 };
        removeDuplicatesOptimal(nums);
        int k = removeDuplicatesOptimal(nums);
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
