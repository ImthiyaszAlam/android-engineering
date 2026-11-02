public class Powernm1 {

    public static int printxnm1(int x, int n) {
        if (n == 1) {
            return x;
        }

        // int xnm1 = printxnm1(x, n - 1);
        // int xn = x * xnm1;
        // return xn;

        return x * printxnm1(x, n - 1);
    }

    public static void main(String[] args) {
        int x = 2;
        int n = 10;
        System.out.println(printxnm1(x, n));
        ;
    }
}
