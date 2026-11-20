import java.util.ArrayList;
import java.util.List;

public class WordSearch {

    static boolean validCoord(int x, int y, int m, int n) {
        if (x >= 0 && x < m && y >= 0 && x < n) {
            return true;
        }
        return false;
    }

    static boolean findWord(int index, String word, char[][] grid, int x, int y, int dirX, int dirY) {
        if (index == word.length()) {
            return true;
        }

        if (validCoord(x, y, grid.length, grid[0].length) && word.charAt(index) == grid[x][y]) {
            return findWord(index, word, grid, x, y, dirX, dirY);
        }
        return false;
    }

    static boolean searchWord(String [][] grid,String word){
        int m = grid.length;
        int n = word.length();
        List<int[]> ans = new ArrayList<>();

        int x[] = {-1,-1,-1,0,0,0,1,1,1};
        int y[] = { -1, 0, 1, -1, 1, -1, 0, 1};


        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int k = 0;k<8;k++){
                    if (findWord(0, word, grid, i, j, x[k], y[k])) {
                        ans.add(new int[]{i,j});
                        break;
                    }
                }
            }
        }
        return ans.toArray(new int[0][]);


    }

    static void printResult(int[][] ans) {
        for (int a[] : ans) {
            System.out.print("{" + a[0] + "," + a[1] + "}" + " ");
        }
    }

    public static void main(String[] args) {
        int index = 0;
        String word = "alam";
        char[][] grid = {
            {'a'},{'b'},{'c'}
        };
        int x = 1;
        int y = 0;
        int dirX = 01;
        int dirY = 10;
        findWord(index, word, grid, x, y, dirX, dirY);
    }
}