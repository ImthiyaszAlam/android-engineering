public class ReverseNumber {

    public static int reverseNum(int a) {
        int reversedNum = 0;
        while (a != 0) {
            reversedNum = reversedNum * 10 + a % 10;
            a = a / 10;
        }
        return reversedNum;
    }

    public static void main(String[] args) {
        int a = 123;
        System.out.println(reverseNum(a));
    }
}
