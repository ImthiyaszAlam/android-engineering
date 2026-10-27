public class ValidPalindrome {
    public static boolean isPalindrome(String str) {
        
        int i = 0, j = str.length() - 1;

        while (i < j) {

            char left = Character.toLowerCase(str.charAt(i));
            char right = Character.toLowerCase(str.charAt(j));

            if (left != right) {
                return false;
            }

            if (!Character.isLetterOrDigit(str.charAt(i))) {
                i++;
                continue;
            } else if (!Character.isLetterOrDigit(str.charAt(j))) {
                j--;
                continue;
            }

            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        String str = "malaya lam";
        boolean result = isPalindrome(str);
        System.out.println(result);
    }

}
