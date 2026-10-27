/**
 * ReverseString
 */
public class ReverseString {
    public static String reverseString(String s){
        int strLen = s.length();
        String reversedString = "";
        for(int i=strLen-1;i>=0;i--){
            reversedString = reversedString+s.charAt(i);
        }
        return reversedString;
    }
    public static void main(String[] args) {
        String str = "annahere";
        System.out.println(reverseString(str));
    }
}