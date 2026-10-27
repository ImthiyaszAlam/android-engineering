import java.util.Scanner;

public class ReverseNumbers {




    public static int reverseNum(int n){

        int reversedNumbers = 0;
        while (n !=0) {
            reversedNumbers = reversedNumbers *10 + n % 10;
            n= n/10;
        }
        System.out.println("Reverse number is " + reversedNumbers);
        return 0 ;
    }
    public static void main(String[] args) {

        int n = 1096564;
        int rev = reverseNum(n);
    }
}
