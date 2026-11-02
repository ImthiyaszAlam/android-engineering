/**
 * Palindrome
 */
public class Palindrome {

    public static void main(String[] args) {
        
        String str = "Anna";
        String s = str.toLowerCase();
        int left = 0;
        int right = s.length()-1;
        while (left<right) {
            if (s.charAt(left) != s.charAt(right)) {
                System.out.println("Not plaindrome");
            
            }
            left++;
            right--;
        }
        
    }
}