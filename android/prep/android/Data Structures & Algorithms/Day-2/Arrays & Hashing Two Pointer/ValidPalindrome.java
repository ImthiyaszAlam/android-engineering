public class ValidPalindrome {

    public static boolean isValidPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {

            while (left < right && !Character.isLetterOrDigit(str.charAt(left)))
                left++;
            while (left < right && !Character.isLetterOrDigit(str.charAt(right)))
                right--;

            char currentCharLeft = str.charAt(left);
            char currentCharRight = str.charAt(right);

            if (Character.toLowerCase(currentCharLeft) != Character.toLowerCase(currentCharRight))
                return false;

            left++;
            right--;

        }

        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isValidPalindrome(s));
    }
}
