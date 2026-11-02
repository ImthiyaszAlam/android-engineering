public class Fibonacci {

    public static int printFibonacci(int n){
        if (n==1 || n==0) {
            return n;
        }
        int fibnm1 = printFibonacci(n-1);
        int fibnm2 = printFibonacci(n-2);
        int fib = fibnm1+fibnm2;
        return fib;
        
    }
    public static void main(String[] args) {
        int n = 25;
        System.out.println(printFibonacci(10));
        System.out.println(printFibonacci(11));
        System.out.println(printFibonacci(12));
        System.out.println(printFibonacci(13));
        System.out.println(printFibonacci(14));
        System.out.println(printFibonacci(15));
    }
}
