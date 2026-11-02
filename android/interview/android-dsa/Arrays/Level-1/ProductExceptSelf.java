public class ProductExceptSelf {

    public static int[] arrayExceptSelf(int nums[]) {

        int n = nums.length;
        int answer[] = new int[n];

        for (int i = 0; i < n; i++) {

            int currentProduct = 1;
            for (int j = 0; j < n; j++) {

                if (i != j) {
                    currentProduct *= nums[j];
                    answer[i] = currentProduct;
                }
            }
        }

        return answer;

    }

    public static void main(String[] args) {

        int[] nums = { 1, 2, 3, 4 };
        int answers[] = arrayExceptSelf(nums);

        for (int num : answers) {
            System.out.print(num + " ");
        }

    }
}
