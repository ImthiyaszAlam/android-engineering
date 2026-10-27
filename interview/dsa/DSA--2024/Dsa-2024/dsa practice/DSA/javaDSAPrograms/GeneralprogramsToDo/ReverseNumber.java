import java.util.Scanner;

public class ReverseNumber {

    public int reverseNumberMethod(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter numbers");
        int userInput = scanner.nextInt();

        int reversedNumber  = 0;
        while (userInput !=0) {
            reversedNumber = reversedNumber * 10 + userInput %10;
            userInput = userInput  / 10;
        }
        scanner.close();
        return reversedNumber;
    }
    public static void main(String[] args) {
        ReverseNumber reverseNumber = new ReverseNumber();
        int reversedNumberIs = reverseNumber.reverseNumberMethod();
        System.out.println(reversedNumberIs);


    }
    public String reverseNumberMethod(String input) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reverseNumberMethod'");
    }
    public int reverseNum(int numbers) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reverseNum'");
    }
}
