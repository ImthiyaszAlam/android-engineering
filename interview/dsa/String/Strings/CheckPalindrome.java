public class CheckPalindrome {
    public static void main(String[] args) {

        String str = "AnnA";
        boolean isPalindrome = isPalindrome(str);
        System.out.println(isPalindrome);
    }

    public static boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
