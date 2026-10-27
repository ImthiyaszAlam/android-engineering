import java.util.Scanner;

public class PerfectSquare {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your number");
        int number = sc.nextInt();
        boolean isPerfectSquare = false;
        for(int i = 1; i * i <= number; i++) {
            if (i * i == number) {
                System.out.println("Given number is a perfect square of " + i);
                isPerfectSquare = true;
                break;
            }
        }
        if (!isPerfectSquare) {
            System.out.println("No perfect square");
        }
    }
}
