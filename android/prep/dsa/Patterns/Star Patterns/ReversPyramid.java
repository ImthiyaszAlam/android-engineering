public class ReversPyramid {
    public static void main(String[] args) {
        int n = 5;

      

        // RA

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // RA Mirror

        for (int i = 0; i < n; i++) {

            for (int j = n - 1; j >= i; j--) {
                System.out.print(" ");
            }

            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Square @

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("@");
            }
            System.out.println();
        }

          // Reverse Pyramid
        for (int i = 0; i < n; i++) {
            for (int k = 0; k <= i; k++) {
                System.out.print(" ");
            }
            for (int j = n - 1; j >= i; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }

    }
}
