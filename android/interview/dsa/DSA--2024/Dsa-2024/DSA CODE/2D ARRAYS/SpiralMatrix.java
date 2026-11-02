public class SpiralMatrix {

    public static void printSpiral(int matrix[][]){
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length-1;
        int endCol = matrix[0].length-1;

        while (startRow<=endRow && startCol <=endCol) {
            // top
            for(int col=startCol;col<=endCol;col++){
                System.out.print(matrix[startRow][col]+" ");
            }
            // right
            for(int row=startRow;row<endRow;row++){
                System.out.print(matrix[row][endCol]+" ");
            }
            // bottom
            for(int bottom = endCol-1;bottom>=startCol;bottom--){
                System.out.print(matrix[endRow][bottom]+" ");
            }
            // left
            for(int left = endRow-1;left>=startRow+1;left--){
                System.out.print(matrix[left][startCol]+" ");
            }
            startRow++;
            startCol++;
            endCol--;
            endRow--;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int matrix[][] = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        };
        printSpiral(matrix);
    }
}
