import java.util.Scanner;

public class NumberOdDijit {
    public int numberOfDigitMethod(int number){

        int count  = 0;

        while (number >0) {
            number = number / 10;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOdDijit numberOdDijit = new NumberOdDijit();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter numbers");
        int number = scanner.nextInt();
        scanner.close();
        int totalNumberOfDigit  = numberOdDijit.numberOfDigitMethod(number);
        System.out.println( "Total numbers in given number is " + totalNumberOfDigit);
        
    }
}
