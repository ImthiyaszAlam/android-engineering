public class ReverseString {

    public static String reverseStringMethod(String s){
        String revString = "" ;
        for(int i=s.length()-1; i>=0; i--){
            revString = revString + s.charAt(i);
        }
    
        return revString;
    }
    public static void main(String[] args) {
        String s = "abcd";
        String rev = reverseStringMethod(s);
        System.out.println(rev);
    }
}
