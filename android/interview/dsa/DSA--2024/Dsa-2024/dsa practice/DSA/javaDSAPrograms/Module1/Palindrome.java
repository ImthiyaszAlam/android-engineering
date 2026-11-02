import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Your Number");

        int number = input.nextInt();

        int originalNumber = number;
        int reversedNumber = 0;

        while (number!=0) {
            reversedNumber = reversedNumber*10 +number%10;
            number = number/10;
        }


        if (originalNumber == reversedNumber) {
            System.out.println("Palindrome");
        }
        else{
            System.out.println("No Palindrome");
        }
    }


}
