public class RepeatingNum {

    public static int printSevCount(int matrix[][], int key) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (key == matrix[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int a[][] = {
                { 4, 7, 8 },
                { 8, 8, 7 }
        };
        int key = 7;
        System.out.println(printSevCount(a, key));
    }
}
