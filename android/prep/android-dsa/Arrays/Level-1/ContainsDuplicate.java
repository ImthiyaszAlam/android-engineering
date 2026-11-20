import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean containsDuplicate1(int nums[]) {

        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        return false;

    }

    public static List<Integer> findDuplicates(int[] nums) {

        List<Integer> duplicates = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    duplicates.add(nums[i]);
                }
            }
        }
        return duplicates;
    }

    public static List<Integer> findDuplicateElements(int nums[]) {

        Set<Integer> seen = new HashSet<>();
        List<Integer> duplicates = new ArrayList<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                duplicates.add(num);
            } else {
                seen.add(num);
            }

        }
        return duplicates;
    }

    public static void main(String[] args) {

        int nums[] = new int[] { 1, 2, 3, 4, 5, 5 };

         System.out.println(containsDuplicate1(nums));
        // System.out.println(findDuplicateElements(nums));
       // System.out.println(findDuplicates(nums));
    }
}