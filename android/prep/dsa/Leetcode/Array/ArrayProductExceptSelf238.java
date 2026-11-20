import java.util.Arrays;

public class ArrayProductExceptSelf238 {

    public static int[] findArraysProduct(int nums[]) {
        int n = nums.length;
        int answers[] = new int[n];
        int prefix[] = new int[n];
        int suffix[] = new int[n];
    

        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        suffix[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            answers[i] = prefix[i] * suffix[i];
        }

        return answers;

    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 4 };
        int[] result =findArraysProduct(nums);
        System.out.println(Arrays.toString(result));
    }
}