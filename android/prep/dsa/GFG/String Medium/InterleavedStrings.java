public class InterleavedStrings {

    public static boolean isIL(String s1, String s2, String s3, int i, int j) {

        int k = i + j;

        if (i == s1.length() && j == s2.length() && k == s3.length()) {
            return true;
        }

        boolean a = (i < s1.length()) && s3.charAt(k) == s1.charAt(i) && isIL(s1, s2, s3, i + 1, j);
        boolean b = (j < s2.length()) && s3.charAt(k) == s2.charAt(j) && isIL(s1, s2, s3, i, j + 1);

        return a || b;

    }

    public static boolean isInterLeaved(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        return isIL(s1, s2, s3, 0, 0);
    }

    public static void main(String[] args) {
        String s1 = "AAB";
        String s2 = "AAC";
        String s3 = "AAAABC";
        System.out.println(isInterLeaved(s1, s2, s3));
    }
}
