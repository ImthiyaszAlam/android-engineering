public class PrdocutArray {

    public static int[] productArrayExceptSelf(int nums[]) {

        int n = nums.length;

        int result[] = new int[n];
        result[0] = 1;

        for (int i = 1; i < n; i++) {
            int preElementInResult = result[i - 1];
            int prevElementInNums = nums[i - 1];
            int product = preElementInResult * prevElementInNums;
            result[i] = product;

        }
        System.out.println("Left Product");
        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }

        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * right;
            right = right * nums[i];
        }
        System.out.println();

        System.out.println("Right Product");
        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }

        return result;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 4 };
        productArrayExceptSelf(nums);
    }
}