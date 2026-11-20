public class SplitString {

    public static boolean strCheck(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;

        }
        return true;
    }

    public static boolean check(String str) {
        if (str.length() >= 10) {
            return true;
        }

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                for (int k = j + 1; k < str.length(); k++) {

                    String s1 = "", s2 = "", s3 = "", s4 = "";

                    try {
                        s1 = str.substring(0, i);
                        s2 = str.substring(i, j - 1);
                        s3 = str.substring(j, k - 1);
                        s4 = str.substring(k, str.length() - k);
                    } catch (StringIndexOutOfBoundsException e) {

                    }

                    if (strCheck(s1, s2) && strCheck(s2, s3) && strCheck(s1, s4) && strCheck(s2, s3) && strCheck(s2, s4)
                            && strCheck(s3, s4)) {
                        return true;
                    }

                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String str = "aaabb";
        if (check(str)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }
}
