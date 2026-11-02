public class CenterExpandingPattern {

    public static void printCenterExpandingPattern(int n) {

        for (int i = 0; i < n; i++) {

            int j;
            for (j = 0; j <= n - i; j++) {
                System.out.print(" ");
            }

            System.out.print(j);
            System.out.print(i);

            for (int k = 0; k <= i; k++) {
                System.out.print("* ");
            }

            System.out.print(j);

            System.out.println();

        }

    }

    public static void main(String[] args) {

        int n = 5;
        printCenterExpandingPattern(n);

    }
}
