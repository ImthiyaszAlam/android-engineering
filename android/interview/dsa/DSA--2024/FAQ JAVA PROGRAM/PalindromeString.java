public class PalindromeString {
    public static String palString(String str){
        String originalString = str;
        String reversedString = "";
        int strLen = str.length();
        for(int i =strLen-1;i>=0;i--){
            reversedString = reversedString+str.charAt(i);
        }
        if (originalString.equals(reversedString)) {
            return reversedString + " : is a palindrome";
        }else{
            return reversedString+  " is not a palindrome";
        }
    }
    public static void main(String[] args) {
        String str = "malayalamm";
        System.out.println(palString(str));
    }
}
