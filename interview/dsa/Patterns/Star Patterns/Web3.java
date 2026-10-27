public class Web3 {
    public static void main(String[] args) {
        int count = 5;
        printPyramid(count);
        printRAT(count);
        printRATMirror(count); 
    }

    private static void printPyramid(int count) {
        for (int i = 0; i < count; i++) {
            for (int j = count - 1; j >= i; j--) {
                System.out.print(" ");
            }

            for (int k = 0; k < i; k++) {
                System.out.print("@ ");
            }

            System.out.println();
        }
    }

    private static void printRAT(int count) {
        for (int i = 0; i < (count); i++) {

            if (i == count - 1) {
                for (int j = 0; j <= i; j++) {
                    System.out.print("*");
                }

                for (int j = 0; j <= count; j++) {
                    System.out.print("@");
                }

                for (int j = 0; j <= i; j++) {
                    System.out.print("*");
                }

            } else {
                for (int j = 0; j <= i; j++) {
                    System.out.print("*");
                }

                for (int j = 0; j <= count; j++) {
                    System.out.print(" ");
                }

                for (int j = 0; j <= i; j++) {
                    System.out.print("*");
                }
            }

            System.out.println();
        }
    }

    private static void printRATMirror(int count) {
        for (int i = 0; i < count; i++) {

            for (int j = count-1; j >= i; j--) {
                System.out.print("*");
            }

            for (int j = 0; j < count; j++) {
                System.out.print(" ");
            }

            for (int j = count; j >= i; j--) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

}
