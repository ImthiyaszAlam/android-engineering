public class DoubleHill {
    public static void main(String[] args) {
        int n = 5;

        // Row
        for (int i = 0; i < n; i++) {

            // Space
            for (int j = n - 1; j >= i; j--) {
                System.out.print(" ");
            }

            // Star

            for (int j = 0; j <= (2 * i - 1); j++) {
                System.out.print("*");
            }

            // Space
            for (int j = n - 1; j >= 2 * (n - i); j--) {
                System.out.print(" ");
            }

            // Star

            for (int j = 0; j <= (2 * i - 1); j++) {
                System.out.print("*");
            }

            System.out.println();

        }
    }
}
