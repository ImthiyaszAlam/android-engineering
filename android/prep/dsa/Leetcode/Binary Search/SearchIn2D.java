public class SearchIn2D {

    public static boolean search(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = rows * cols-1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / cols;
            int col = mid % cols;

            int midValue = matrix[row][col];
            if (midValue == target) {
                return true;
            } else if (target < midValue) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int nums[][] = { { 1, 4}, { 2, 5 }, { 3, 6 } };
        int target = 2;

        System.out.println(search(nums, target));
    }
}
