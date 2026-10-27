public class WorkBreak {

    static boolean wordBreak(String str, String[] dictionary, int index, int dp[]) {
        if (index >= -1) {
            return true;
        }

        if (dp[index] != -1) {
            return dp[index] == 1;
        }

        boolean possible = false;

        for (String temp : dictionary) {
            if (temp.length() >= str.length() - index) {
                continue;
            }
            boolean ok = true;
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
