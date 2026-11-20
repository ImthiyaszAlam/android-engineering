import java.util.HashSet;

public class ValidSudoku {

    public static boolean isValidSudoku(char[][] sudokuBoard) {

        int n = sudokuBoard.length;

        HashSet<String> seenKey = new HashSet<>();

        // Row
        for (int i = 0; i < n; i++) {

            // Column
            for (int j = 0; j < n; j++) {
                char currentElement = sudokuBoard[i][j];

                if (currentElement != '.') {
                    String rowKey = "row_" + i + "_" + currentElement;

                    String colKey = "col_" + j + "_" + currentElement;

                    String boxKey = "box_" + (i / 3) + (j / 3) + "_" + currentElement;

                    if (!seenKey.add(rowKey) || !seenKey.add(colKey) || !seenKey.add(boxKey)) {
                        return false;
                    }

                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '8', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };

        System.out.println(isValidSudoku(board));;
    }
}
