public class Web5 {
    public static void main(String[] args) {
        int count = 5;
        printUpperPart(count);
        printSquare(count);
        printPyramid(count);
    }

    public static void printUpperPart(int n) {
        for (int i = 1; i <= n; i++) {

            if (i == n) {
                for (int j = 1; j <= i; j++) {
                    System.out.print("*");
                }

                int spaces = 2 * (n - i);
                for (int j = 1; j <= n; j++) {
                    System.out.print("@");
                }

                for (int j = 1; j <= i; j++) {
                    System.out.print("*");
                }

                System.out.println();
            } else {

                for (int j = 1; j <= i; j++) {
                    System.out.print("*");
                }

                int spaces = 2 * (n - i);
                for (int j = 1; j <= spaces; j++) {
                    System.out.print(" ");
                }

                for (int j = 1; j <= i; j++) {
                    System.out.print("*");
                }

                System.out.println();

            }

        }
    }

    public static void printSquare(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < n; j++) {
                System.out.print("@");
            }

            System.out.println();
        }
    }

    public static void printPyramid(int n) {

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print(" ");
            }

            int stars = n - 2 * i;
            for (int j = 0; j < stars; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

}
