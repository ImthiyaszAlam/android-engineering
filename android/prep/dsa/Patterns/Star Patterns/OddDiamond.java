public class OddDiamond {


    public static void main(String[] args) {
        
            int n = 5;

        // Upper Pyramind

        for (int i = 0; i < n; i++) {

            // Space
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }

            // Star
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }

            // next Line
            System.out.println();
        }


        // Lower Pyramind

        for (int i = 0; i < n; i++) {

            for (int j = 0; j <= i; j++) {
                System.out.print(" ");
            }

            for (int j = n - 2; j >= i; j--) {
                System.out.print(" *");
            }

            System.out.println();
        }
  
    }
}
