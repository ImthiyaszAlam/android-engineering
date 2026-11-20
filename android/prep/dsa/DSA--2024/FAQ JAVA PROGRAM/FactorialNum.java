import java.util.Scanner;

public class FactorialNum {

    public static int factorial(int num){
        int factorial = 1;
        for(int i=1;i<=num;i++){
            factorial*=i;
        }
        return factorial;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter number");
        int num = sc.nextInt();
        System.out.println("factorila of "+num+" is : " +factorial(num));
    }
}
