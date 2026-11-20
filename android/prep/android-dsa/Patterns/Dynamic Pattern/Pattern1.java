/**
 * Pattern1
 */
public class Pattern1 {

    public static void main(String[] args) {

        int n = 5;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }

            for (int k = 0; k < 2 * i + 1; k++) {
                System.out.print("*");
            }

            System.out.println();
        }
        // stars below the center
        
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < 2 * n - 1; j++) {
                if (j == n - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }

    }

}