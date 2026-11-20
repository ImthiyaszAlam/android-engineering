public class Pyramid {
    public static void main(String[] args) {
        int numRows=5;
        for(int i=0;i<=numRows;i++){
            for(int j=i;j<=numRows-1;j++){
                System.out.print("  ");
            }
            for(int k=0;k<=2*i-1;k++){
                System.out.print("*");
            }

            System.out.println();
        }
    }
}
