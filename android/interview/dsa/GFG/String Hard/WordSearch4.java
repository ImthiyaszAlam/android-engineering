public class WordSearch4 {

    static boolean findMatch(char[][] mat, String word, int x, int y, int widX) {

        int wLen = word.length();
        int m = mat.length;
        int n = mat[0].length;

        if (widX == wLen) {
            return true;
        }

        if (x < 0 || y < 0 || x >= n || y >= m) {
            return false;
        }

        if (mat[x][y] == word.charAt(widX)) {

            char temp = mat[x][y];
            mat[x][y] = '#';

            boolean res = findMatch(mat, word, x - 1, y, widX + 1) ||
                    findMatch(mat, word, x + 1, y, widX + 1) ||
                    findMatch(mat, word, x, y-1, widX + 1)||
                    findMatch(mat, word, x, y+1, widX + 1);
        }

        return false;
    }


    static boolean isWordExist(char [][] mat,String word){

        int wLen = word.length();
        int n = mat.length;
        int m = mat[0].length;

        if (wLen>(n*m)) {
            return false;
        }

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if (mat[i][j] ==word.charAt(0)) {
                    if (findMatch(mat, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }




        return false;
    }
    public static void main(String[] args) {

        char [][] mat = {{'T','E','E'},{'S','G','K'},{'T','E','L'}};
        String word = "TST";

        System.out.println(isWordExist(mat, word));

    }
}
