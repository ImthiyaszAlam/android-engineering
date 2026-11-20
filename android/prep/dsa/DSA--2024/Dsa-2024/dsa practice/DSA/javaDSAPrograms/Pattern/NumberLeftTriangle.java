public class NumberLeftTriangle {

    public static void pattern5(int n){
        for(int row=1; row<=n;row++){
            for(int column = 1; column<=row;column++){
                System.out.print(column+ "");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int n=5;
        pattern5(5);
        System.out.println();
    }
}
