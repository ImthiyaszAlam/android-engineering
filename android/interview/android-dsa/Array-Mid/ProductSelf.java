
public class ProductSelf {

    public static int[] findProduct(int nums[]) {

        int n = nums.length;
        int answers[] = new int[n];

        for (int i = 0; i < n; i++) {
            int currentProduct = 1;

            for (int j = 0; j < n; j++) {

                if (i != j) {
                    currentProduct = currentProduct * nums[j];
                }
            }
            answers[i] = currentProduct;
        }

        return answers;

    }

    public static int[] findProductArray(int nums[]) {

        int n = nums.length;
        int answer[] = new int[n];

        int prefix[] = new int[n];
        int suffix[] = new int[n];

        prefix[0] = 1;
        suffix[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            answer[i] = prefix[i] * suffix[i];
        }

        return answer;

    }

    public static void main(String[] args) {

        int nums[] = { 2, 4, 6, 9 };
        int answers[] = findProductArray(nums);

        for (int i = 0; i < answers.length; i++) {
            System.out.print(answers[i] + " ");
        }

    }
}