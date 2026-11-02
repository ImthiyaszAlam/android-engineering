public class HollowInvertedPyramid {
    public static void main(String[] args) {
        int n = 5;

        for(int i=0;i<n;i++){


            //space

            for(int j=0;j<i;j++){
                System.out.print(" ");
            }


        // Stars and hollow space
            int starsInRow = 2 * (n - i) - 1;
            for (int j = 0; j < starsInRow; j++) {
                if (j == 0 || j == starsInRow - 1 || i == 0) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }

            System.out.println();

        }
    }
}
