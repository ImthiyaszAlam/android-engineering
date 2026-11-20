public class SecondPattern {
    public static void main(String[] args) {
        int star = 5;
        for(int row=0;row<=star;row++){
            for(int col=star;col>=row;col--){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
