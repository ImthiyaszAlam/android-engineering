public class RemoveCharOccurence {

    public static String removeChar(String str, char ch) {
        StringBuilder result = new StringBuilder(str);
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) == ch) {
                result.deleteCharAt(i);
                i--;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String str = "alam";
        char ch = 'a';
        System.out.println(removeChar(str, ch));
    }
}
