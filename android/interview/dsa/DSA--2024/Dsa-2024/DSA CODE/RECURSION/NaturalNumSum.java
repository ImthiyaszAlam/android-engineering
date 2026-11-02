public class NaturalNumSum {

    public static int printSum(int n) {
        if (n == 1) {
            return 1;
        }
        int sumnm1 = printSum(n - 1);
        int sum = n + sumnm1;
        return sum;

    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(printSum(n));
    }
}
