import java.util.Scanner;

public class PalindromeString {

    public static boolean isPalindromeString(String str){
        str = str.toLowerCase();
     
        int left = 0;
        int right = str.length()-1;
        while (left<right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
         
            }
            left++;
            right--;
        }

        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        String str = sc.next();

        if (isPalindromeString(str)) {
            System.out.println(str + " is a palindrome string");
        }else{
            System.out.println(str + " is not a palindrome string");
        }
    }
}
