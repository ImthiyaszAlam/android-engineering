public class Arrow {
    public static void main(String[] args) {
        int n = 5;

        // Top half
        for (int i = 1; i <= n; i++) {
            printStars(i);
            System.out.println();
        }

        // Arrow shaft (centered star)
        printStars(n);
        printSpace(n);
        System.out.println("*");

        // Arrow body (long line)
        printStars(2 * n + 1);
        System.out.println();

        // Bottom half (mirror of top half)
        for (int i = n; i >= 1; i--) {
            printStars(i);
            printSpace(n);
            System.out.println();
        }
    }

    private static void printStars(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("*");
        }
    }

    private static void printSpace(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }
}
