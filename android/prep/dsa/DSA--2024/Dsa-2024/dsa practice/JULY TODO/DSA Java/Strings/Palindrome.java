public class Palindrome {
    public static void main(String[] args) {
        String str = "aaam";
        String originalString = str;
        String reverseString = "";
        for(int i=str.length()-1;i>=0;i--){
            reverseString = reverseString+str.charAt(i);
        }
        if (originalString.equals(reverseString)) {
            System.out.println(originalString+" is a palindrome");
        }else{
            
            System.out.println(originalString+" is not  a palindrome");
        }
    }
}
