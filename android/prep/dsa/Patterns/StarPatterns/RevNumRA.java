import java.util.Scanner;

public class RevNumRA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number length");
        int n=sc.nextInt();
        sc.close();

        for(int i=0;i<n;i++){
            for(int j=n-1;j>=i;j--){
                System.out.print(" ");
            }

            for(int k=0;k<=i;k++){
                System.out.print(k);
            }

            System.out.println();
        }
    }
}
