public class AphabetPyramid {
    public static void main(String[] args) {

        int a = 65;
        int n = 5;

        for (int i = 0; i < n; i++) {

            // space

            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }

            // alpahabets

            for (int j = 0; j <= i; j++) {
                System.out.print((char) (a) + " ");
                a++;
            }

            System.out.println();
        }

        for (int i = 0; i < n; i++) {

            // alphabets

            for (int j = 0; j <= i - 1; j++) {
                System.out.print(" ");

            }

            for (int j = 0; j <= n - i - 1; j++) {
                if (a > 90) {
                    a = 65;
                }
                System.out.print((char) (a) + " ");

                a++;
            }

            System.out.println();

        }

    }
}
