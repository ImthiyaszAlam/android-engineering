import java.util.Scanner;

public class EvenOddDigitCount {


    public static void oddEvenCountMethod(int userInput){

        int oddCount = 0;
        int evenCount = 0;

        while (userInput != 0) {
            int didgit = userInput % 10;
            if (didgit % 2 == 0) {
                evenCount++;
            }else{
                oddCount++;
            }

            userInput = userInput /10;
        }
        System.out.println("even numbers count " + evenCount);
        System.out.println("odd numbers count " + oddCount);

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number");
        int userInput = scanner.nextInt();
        scanner.close();
        oddEvenCountMethod(userInput);
    }
}
