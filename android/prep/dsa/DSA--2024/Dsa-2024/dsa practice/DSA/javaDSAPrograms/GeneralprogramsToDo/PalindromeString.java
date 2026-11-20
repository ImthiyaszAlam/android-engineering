public class PalindromeString {


    public static boolean isPalindromeString(String s ){
        String originalString = s;
        String reversedString = "" ;
        int length = s.length()-1;
        for(int i=length ;i>=0; i--){
            reversedString = reversedString + s.charAt(i);

        }
        return originalString . equals(reversedString);
    }
    public static void main(String[] args) {
        PalindromeString palindromeString = new PalindromeString();
        String s= "MALAYALAM";
        boolean PalindromeString =palindromeString.isPalindromeString(s);
        System.out.println(PalindromeString);
        
    }
}
