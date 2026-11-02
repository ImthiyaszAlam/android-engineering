public class RevrseString {
    public static void main(String[] args) {
        String str = "CodingDsa";
        String reversedString = "";

        for(int i=str.length()-1; i>=0; i--){
            reversedString = reversedString+str.charAt(i);
        }

        System.out.println(reversedString);
    }
}
