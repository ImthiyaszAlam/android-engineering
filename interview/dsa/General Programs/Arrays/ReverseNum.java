public class ReverseNum {
    public static void main(String[] args) {
        int num = 123;

        int rev = 0;

        while (num != 0) {
            rev = rev * 10 + num % 10; //    rev = 0*10 + num % 10  Last number  = 3
            num = num / 10;            //    remained 12
        }
        System.out.println(rev);
    }
}
