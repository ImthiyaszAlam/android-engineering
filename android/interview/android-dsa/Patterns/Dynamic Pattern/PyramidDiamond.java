/**
 * PyramidDiamond
 */
public class PyramidDiamond {

    public static void main(String[] args) {

        int n = 5;

        for (int i = 0; i < n; i++) {

            // Space

            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }

            // Star

            for (int k = 0; k <= i; k++) {
                System.out.print("*");
            }

            // Space

            for (int j = 0; j <= n; j++) {
                if (i == n / 2) {
                    System.out.print("@");
                } else {

                }
                System.out.print(" ");
            }

            for(int l = 0;l<=i;l++){
                System.out.print("*");
            }

            System.out.println();
        }
    }
}