public class ReverseAlphabetRA {
    public static void main(String[] args) {
        int n = 5;
        int alphabet = 65;

        for (int i = 0; i < n; i++) {

            for (int j = n - i; j >= 0; j--) {
                System.out.print(" ");
            }

            for (int k = 0; k <= i; k++) {
                System.out.print((char) (alphabet + 1));
            }

            System.out.println();
        }
    }
}
