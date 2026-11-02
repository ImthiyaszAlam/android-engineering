import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class ContainsDuplicate {

    public static boolean containsDuplicate(int nums[]) {

        HashSet<Integer> duplicateMap = new HashSet<>();

        for (int i=0;i<nums.length;i++) {

            if (duplicateMap.contains(nums[i])) {
                return true;
            }
            duplicateMap.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {

        int nums[] = { 1, 2, 3, 1 };
        int nums1[] = { 1, 2, 3, 4 };

        System.out.println(containsDuplicate(nums));
        ;
        System.out.println();
        System.out.println(containsDuplicate(nums1));
        ;

    }
}