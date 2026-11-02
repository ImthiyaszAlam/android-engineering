public class DigitSum {

    public static int digitSum(int num){
        int sum = 0;
        while (num!=0) {
            int digit = num%10;
            sum+=digit;
            num/=10;
        }
        return sum;
    }
    public static void main(String[] args) {
        int num = 1234567890;
        System.out.println(digitSum(num));
    }
}
