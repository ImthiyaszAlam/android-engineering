import java.util.Scanner;

public class Diagonal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ENTER A NUMBER");
        int n = scanner.nextInt();
        scanner.close();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j) {
                    System.out.print("*");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }
}
