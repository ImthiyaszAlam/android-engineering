public class PalindromeString {
    public static void main(String[] args) {
        String str = "Anna";
        String reverseString = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            char currentChar = str.charAt(i);
            reverseString+=currentChar;
        }

        if (str.equalsIgnoreCase(reverseString)) {
            System.out.println(true);
        }else{
            System.out.println(false);
        }

    }
}
