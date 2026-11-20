public class SecondRowSum {

    public static int printSecondRowSum(int matrix[][]){
        int sum = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if (i == 1) {
                    sum+=matrix[i][j];
                }
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int nums[][] = {
            {1,4,9},
            {11,4,3},
            {2,2,3}
        };
        System.out.println(printSecondRowSum(nums));
    }
}
