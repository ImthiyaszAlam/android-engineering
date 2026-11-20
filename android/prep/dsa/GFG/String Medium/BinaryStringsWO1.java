public class BinaryStringsWO1 {

    static int countRecur(int i,int n){
        if (i>=n) {
            return 1;
        }

        int take = countRecur(i+2,n);
        int noTake = countRecur(i+1, n);
    }
    public static void main(String[] args) {
        
    }
}
