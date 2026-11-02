public class FibonacciNum {

    public static int printFibonacci(int n) {
    
        if (n == 0 || n == 1) {
            return n;
        }

        int fibNm1 = printFibonacci(n - 1);
        int finNum2 = printFibonacci(n - 2);
        int fibN = fibNm1 + finNum2;
        return fibN;
    }

    public static void main(String[] args) {
        int n = 26;
        System.out.println(printFibonacci(n));
    }
}
