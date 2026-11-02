import java.util.ArrayList;
import java.util.List;

public class MaximumConsecutive {

    public static int findMaxConsecutiveOne(int nums[]) {
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                int count = 0;
                int j = i;

                while (j < nums.length && nums[j] == 1) {
                    count++;
                    j++;
                }
                max = Math.max(max, count);
            }

        }
        return max;

    }

    public static int findMaxCons(int nums[]) {

        int max = 0;
        int currentMax = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                currentMax++;
            } else {
                currentMax = 0;
            }

            max = Math.max(max, currentMax);
        }

        return max;
    }

    public static List<Integer> maxConsElements(int nums[]) {
        List<Integer> maxElements = new ArrayList<>();
        List<Integer> currentElement = new ArrayList<>();

        int max = 0;
        int currentMax = 0;

        for (int num : nums) {
            if (num == 1) {
                currentMax++;
                currentElement.add(num);
                if (currentElement.size() > maxElements.size()) {
                    maxElements = new ArrayList<>(currentElement);
                }
            } else {
                currentMax = 0;
                currentElement.clear();
            }
            max = Math.max(max, currentMax);
        }

        return maxElements;

    }

    public static void moveZeroesToFront(int nums[]) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {

            if (nums[right] == 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }

        }
    }

    public static void main(String[] args) {
        int nums[] = { 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1 };
        System.out.println(findMaxConsecutiveOne(nums));
        // System.out.println(findMaxCons(nums));
        // System.out.println(maxConsElements(nums));
        // moveZeroesToFront(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }

    }
}
