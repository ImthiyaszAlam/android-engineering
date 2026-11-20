public class SameString {

    public static boolean isSame(String str1, String str2) {


        if (str1.length()!=str2.length()) {
            return false;
        }
        int i;

        for (i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str1 = "almm";
        String str2 = "alam";
        System.out.println(isSame(str1, str2));
    }
}