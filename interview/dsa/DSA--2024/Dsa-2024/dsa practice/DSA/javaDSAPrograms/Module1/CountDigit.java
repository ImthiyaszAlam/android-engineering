public class CountDigit {


    public static void main(String[] args) {
        int digit  = 1234567890;
        int count = 0;

        while (digit>0) {
            digit = digit/10;
            count++;
        }

        System.out.println(count);
    }
}
