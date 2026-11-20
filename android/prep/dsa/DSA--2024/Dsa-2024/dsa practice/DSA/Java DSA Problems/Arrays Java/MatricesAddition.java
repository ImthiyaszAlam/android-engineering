import java.util.Scanner;

public class MatricesAddition {
    public static void main(String[] args) {
        int rows;
        int cols;
        Scanner sc = null;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter no of rows");
            rows = sc.nextInt();
            System.out.println("Enter no of cols");
            cols = sc.nextInt();

            int matrix1[][] = new int[rows][cols];
            int matrix2[][] = new int[rows][cols];
            int resultantMatrix[][] = new int[rows][cols];

            System.out.println("Enter elements of first matrix");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix1[i][j] = sc.nextInt();
                }
            }

            System.out.println("First Matrix:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print(matrix1[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("Enter elements of second matrix");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix2[i][j] = sc.nextInt();
                }

            }

            System.out.println("Second Matrix:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print(matrix2[i][j] + " ");
                }
                System.out.println();
            }

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    resultantMatrix[i][j] = matrix1[i][j] / matrix2[i][j];

                }
            }
            System.out.println("Resultant Matrix is:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print(resultantMatrix[i][j] + " ");
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
    }
}
