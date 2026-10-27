import java.util.Scanner;

public class HoloT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Your desired length");
        int n = scanner.nextInt();
        scanner.close();


        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){

                if (j==0 || i==j || i==n-1) {
                      System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
