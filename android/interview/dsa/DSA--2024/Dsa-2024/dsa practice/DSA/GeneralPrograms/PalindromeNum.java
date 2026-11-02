import java.util.Scanner;

public class PalindromeNum {

    public static boolean isPalindrome(int num){
        int originalNum = num;
        int reversedNum =0;

        while (num!=0) {
            int lastDigit = num % 10;
            reversedNum = reversedNum * 10 + lastDigit;
            num = num/10;
        }

     
        return originalNum == reversedNum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number ");
        int num = sc.nextInt();

        if (isPalindrome(num)) {
            System.out.println(num + " is a palindrome number");
        }else{
            System.out.println(num + " is not a palindrome number");
        }
    }
}
