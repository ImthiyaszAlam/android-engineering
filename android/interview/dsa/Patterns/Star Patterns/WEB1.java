public class WEB1 {

    public static void main(String[] args) {
        int n = 5;

        // 1. Triangle with Mirror
        for (int i = 1; i <= n; i++) {
            // Left stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            // Middle spaces
            for (int j = 1; j <= (n - i) * 2 + n; j++) {
                System.out.print(" ");
            }

            // Right stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }

        // 2. Square of @ signs aligned under center
        for (int i = 0; i < n; i++) {
            // Add n spaces for centering
            for (int j = 0; j < n; j++) {
                System.out.print(" ");
            }
            // Square of @
            for (int j = 0; j < n; j++) {
                System.out.print("@");
            }
            System.out.println();
        }

        // 3. Inverted Pyramid
        for (int i = n; i >= 1; i -= 2) {
            // Add spaces for centering
            for (int j = 0; j < ((n - i) / 2) + n; j++) {
                System.out.print(" ");
            }
            // Print stars
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

}
