public class Palindrome {

    public boolean isPalindromeMethod(String string , int left, int right){
        if (left>=right) {
            return true;

        }
        if (string.charAt(left) != string.charAt(right)) {
            return false;
        }

        return isPalindromeMethod(string, left+1, right-1);
    }
    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        String s  = "RACECR";
        boolean isPalindrome  = palindrome.isPalindromeMethod(s, 0, s.length()-1);
        System.out.println(isPalindrome);
    }
}