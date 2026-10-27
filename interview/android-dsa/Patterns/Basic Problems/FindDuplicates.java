import java.util.ArrayList;
import java.util.List;

public class FindDuplicates {

    public static List<Integer> returnDuplicates(int nums[]) {

        List<Integer> duplicates = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    if (!duplicates.contains(nums[i])) {
                        duplicates.add(nums[i]);
                    }
                    break;
                }
            }
        }
        return duplicates;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 4, 5, 2, 3, 4 };
        List<Integer> result = returnDuplicates(nums);
        System.out.println(result);

    }
}
