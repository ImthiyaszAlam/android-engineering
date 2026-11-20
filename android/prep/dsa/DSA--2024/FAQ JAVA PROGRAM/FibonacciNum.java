public class FibonacciNum {

    public static void fibonacciSeries(int term){
        int a= 0;
        int b = 1;
        int c = 0;

        for(int i=2;i<=term;i++){
            System.out.print(a+" ");
            c = a+b;
            a = b;
            b = c;
        }
    
    }
    public static void main(String[] args) {
        int term = 10;
    fibonacciSeries(term);
    }
}
