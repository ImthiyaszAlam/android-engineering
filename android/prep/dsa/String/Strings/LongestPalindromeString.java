public class LongestPalindromeString {

    public static int expandAroundCeneter(String str, int left, int right) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static String findLongestSubString(String str) {
        if (str == null || str.length() < 1)
            return "";
        int start = 0;
        int right = 0;

        for (int i = 0; i < str.length(); i++) {
            int len1 = expandAroundCeneter(str, i, i);
            int len2 = expandAroundCeneter(str, i, i + 1);
            int len = Math.max(len1, len2);

            if (len > right - start) {
                start = i - (len - 1) / 2;
                right = i + len / 2;
            }
        }
        return str.substring(start, right + 1);

    }

    public static void main(String[] args) {
        String str = "abba";
        System.out.println(findLongestSubString(str));
    }
}
