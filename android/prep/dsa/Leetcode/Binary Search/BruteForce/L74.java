public class L74 {

    public static boolean search(int[][] matrix, int target) {
        for (int i = 0; i <= matrix.length - 1; i++) {
            for (int j = 0; j <= matrix[0].length - 1; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
     
    }

    public static void main(String[] args) {
        int a[][] = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        int target = 9;

        System.out.println(search(a, target));
    }
}