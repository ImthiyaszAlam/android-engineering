public class SumDigits {

    public static void main(String[] args) {
        int number = 1234;
        int sum = 0;

        while (number>0) {
            int lastNumber = number%10;
            sum = sum+lastNumber;
            number = number/10;
        }
        System.out.println(sum);
    }
}