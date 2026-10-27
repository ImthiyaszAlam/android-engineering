import java.util.Scanner;

public class FibonacciSeries {

    public static int printFibonacciSeries(int n){
        if (n<=1) {
            return n;
        }else{
            return printFibonacciSeries(n-1) + printFibonacciSeries(n-2);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number n");
        int n = sc.nextInt();

        System.out.println(printFibonacciSeries(n));
    }
}
