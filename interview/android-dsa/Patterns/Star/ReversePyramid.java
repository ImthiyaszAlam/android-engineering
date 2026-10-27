public class ReversePyramid {

    public static void main(String[] args) {
        int n = 5;

        for (int i = 0; i < n; i++) {

            for (int k = 0; k < i; k++) {
                System.out.print(" ");
            }

            for (int j = i; j < n; j++) {
                System.out.print("*");
            }

            for (int j = i+1 ; j < n; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

}
