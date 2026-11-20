public class ConcentSquarePattern {
    public static void main(String[] args) {
        int n = 5;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                int row = i;
                int col = j;

                int totalMinRowMin1 = n - i - 1;

                int totalMinColMin1 = n - j - 1;

                int minInRowCol = Math.min(row, col);
                int min2 = Math.min(totalMinRowMin1, totalMinColMin1);

                    // Calculate current layer number

                int layer = Math.min(minInRowCol, min2);

                
                // Alternate characters based on layer
            
                if (layer % 2 == 0) {
                    System.out.print("*");
                } else {
                    System.out.print("#");
                }
            }

            System.out.println();

        }
    }
}
