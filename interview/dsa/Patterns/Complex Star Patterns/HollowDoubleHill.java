public class HollowDoubleHill {
    public static void main(String[] args) {

        int n = 5;

        for (int i = 0; i < n; i++) {

            // space

            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }

            // star

            for (int j = 0; j <= i; j++) {

                int firstIndexInRow = 0;
                int lastIndexInRow = i;

                if (j == lastIndexInRow || j == firstIndexInRow) {
                    System.out.print("*" + " ");
                } else {
                    System.out.print("  ");
                }
            }

            // space between pyramids

            for (int j = 0; j < 2 * (n - i - 1); j++) {
                System.out.print(" ");
            }

            // star

            for (int j = 0; j <= i; j++) {

                int firstIndexInRow = 0;
                int lastIndexInRow = i;

                if (j == lastIndexInRow || j == firstIndexInRow) {
                    System.out.print("*" + " ");
                } else {
                    System.out.print("  ");
                }
            }

            // next Line
            System.out.println();

        }

        // lOWER HALF

        for (int i = 0; i < n; i++) {

            // space

            for (int j = 0; j <= i; j++) {
                System.out.print(" ");
            }

            // star

            for (int j = 0; j < n - i - 1; j++) {

                int firstIndexInRow = 0;
                int lastIndexInRow = n-i-2;

                if (j == lastIndexInRow || j == firstIndexInRow) {
                    System.out.print("*"+" ");
                } else {
                    System.out.print("  ");
                }
            }

            // space between pyramids

              // Spaces between inverted pyramids
              for (int j = 0; j < 2 * i; j++) {
                System.out.print(" ");
            }

      
            for (int j = 0; j < n - i - 1; j++) {
                if (j == 0 || j == n - i - 2) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }

            System.out.println();

        }

    }
}
