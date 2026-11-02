import java.util.Scanner;

public class StarMix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length: ");

        int n = sc.nextInt();
        sc.close();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (j == 1) {
                    System.out.print("1 ");
                } else if (j == i) {
                    System.out.print(i + " ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }

    }
}
