public class Palindrome {



    public static boolean isPalindrome( int n){

        int originalNumber = n;
        int reversedNumbers = 0;
        while (n != 0) {
            reversedNumbers = reversedNumbers *10 + n %10;
            n = n/10;
        }
        return originalNumber == reversedNumbers;
        

    }
    public static void main(String[] args) {
        int n = 121;
        boolean palindrome = isPalindrome(n);
        System.out.println(palindrome);
    }
}
