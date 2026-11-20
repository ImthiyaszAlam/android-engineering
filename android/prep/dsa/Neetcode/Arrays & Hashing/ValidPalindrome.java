public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        int firstIndex = 0;
        int lastIndex = s.length() - 1;

        while (firstIndex < lastIndex) {

            // Skip non-alphanumeric from start
            while (firstIndex < lastIndex && !Character.isLetterOrDigit(s.charAt(firstIndex))) {
                firstIndex++;
            }

            // Skip non-alphanumeric from end
            while (firstIndex < lastIndex && !Character.isLetterOrDigit(s.charAt(lastIndex))) {
                lastIndex--;
            }

            // Compare characters in lowercase
            if (Character.toLowerCase(s.charAt(firstIndex)) != Character.toLowerCase(s.charAt(lastIndex))) {
                return false;
            }

            firstIndex++;
            lastIndex--;
        }

        return true;
    }

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(str)); // Output: true
    }
}
