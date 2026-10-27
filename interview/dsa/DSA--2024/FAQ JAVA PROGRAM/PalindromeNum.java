public class PalindromeNum {

    public static boolean palindromeNum(int num) {
        int originalNum = num;
        int reversedNum = 0;
        while (num != 0) {
            reversedNum = reversedNum * 10 + num % 10;
            num = num / 10;
        }
        if (reversedNum == originalNum) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int num = 11211;
        System.out.println(palindromeNum(num));
    }
}
