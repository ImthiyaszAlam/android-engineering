public class ReverseString {
    public static void main(String[] args) {

        String str = "Alam";
        String reverseString = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            char currentChar = str.charAt(i);
            reverseString += currentChar;
        }

        System.out.println(reverseString);

    }
}
