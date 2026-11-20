import java.util.StringTokenizer;

public class ValidateIPAddress {

    public static boolean isValid(String str) {

        if (str.length() < 7) {
            return false;
        }

        StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
        int count = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String subString = stringTokenizer.nextToken();
            count++;

            if (subString.length() > 1 && subString.charAt(0) == '0') {
                return false;
            }

            for (int j = 0; j < subString.length(); j++) {
                if (!Character.isDigit(subString.charAt(j))) {
                    return false;
                }
            }

            if (Integer.parseInt(subString) > 255) {
                return false;
            }
        }

        if (count != 4) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "168.0.0.1";
        System.out.println(isValid(s));
    }
}
