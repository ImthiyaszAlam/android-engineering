public class DigitNumber {

    public static int digitNum(int a){
        int count = 0;
        while (a!=0) {
            a/=10;
            count++;
        }
        return  count;
    }
    public static void main(String[] args) {
        int num = 1234567890;
        System.out.println(digitNum(num));
    }
}
