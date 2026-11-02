import java.util.Scanner;

public class PrimeToN {


    public static boolean isPrime(int num){

        if (num<1) {
            return false;
        }else{


            for(int i=2; i<=Math.sqrt(num); i++){
                if (num % i ==0) {
                     return false;
                }
            }
            return true;
        }
    }




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number :N");
        int num = sc.nextInt();
        int count = 0 ;
        int primeNumSum = 0;
        for(int i =2; i<=num;i++){
            if (isPrime(i)) {
                System.out.print(i + " ");
                count++;
                primeNumSum+=i;
            }
        }

        System.out.println();
        System.out.println("total Prime number from 1 to " + num + " is :"+ count);
        System.out.println("total sum of Prime number from 1 to " + num + " is :"+ primeNumSum);
    }
}
