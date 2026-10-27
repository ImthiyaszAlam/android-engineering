import java.util.HashSet;
import java.util.Set;

public class Duplicates {

    public static Set<Integer> findDuplicateNum(int nums[]) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();

        for (int num : nums) {
            if (!seen.add(num)) {
                duplicates.add(num);
            }
        }
        return duplicates;

    }

    public static void main(String[] args) {
        int nums[] = {1,2,3,4,2,3,4};
        System.out.println(findDuplicateNum(nums));
    }
}
