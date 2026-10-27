public class findChar {

    public static int findChar(String str, char ch) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String str = "malam";
        char ch = 'a';
        System.out.println(findChar(str, ch));

    }
}
