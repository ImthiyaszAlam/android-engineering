public class Web4 {
    public static void main(String[] args) {

        int count = 5;
        upperPart(count);
        printLowerPart(count);

    }

    private static void upperPart(int n) {

        int half = n / 2;

        // Top half: decreasing '@'
        for (int i = 0; i <= half; i++) {
            // Print spaces
            for (int s = 0; s < half - i; s++) {
                System.out.print(" ");
            }

            // Print '@' characters
            for (int j = 0; j < n - 2 * i; j++) {
                System.out.print("@");
            }

            System.out.println();
        }

    }

    private static void printLowerPart(int count) {
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                if (j == 0 || j == (count - 1) || i == 0) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }
}
