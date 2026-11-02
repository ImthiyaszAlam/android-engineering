import java.util.Scanner;

public class Creation {

    public static boolean search(int a[][], int key) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (key == a[i][j]) {
                    System.out.println("element found at " + i + " " + j);
                    return true;
                }
            }
        }
        System.out.println("key not found ");
        return false;
    }

    public static void main(String[] args) {
        int matrix[][] = new int[3][3];
        int n = 2;
        int m = 2;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter elements");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        search(matrix, 5);

    }
}