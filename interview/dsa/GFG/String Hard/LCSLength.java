public class LCSLength {

    static int lcs(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    static int waysToIncreaseLCSBy1(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int lcs1 = lcs(s1, s2);

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                String updateStr = s1.substring(0, i) + ch + s1.substring(i);
                int lcs2 = lcs(updateStr, s2);
                if (lcs2 == lcs1 + 1) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s1 = "abab";
        String s2 = "abc";
        System.out.println(waysToIncreaseLCSBy1(s1, s2));

    }
}
