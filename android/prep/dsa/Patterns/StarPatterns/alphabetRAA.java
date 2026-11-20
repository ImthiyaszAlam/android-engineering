public class alphabetRAA {
    public static void main(String[] args) {

        int n = 5;
        int a = 65;

        for (int i = 0; i < n; i++) {


            //spaces

            for(int j=1;j<=n-i-1;j++){
                System.out.print("  ");
            }

            //alphabets


            for(int j=0;j<=i;j++){
                System.out.print((char)(a)+" ");
                a++;
            }



            System.out.println();
        }
    }
}
