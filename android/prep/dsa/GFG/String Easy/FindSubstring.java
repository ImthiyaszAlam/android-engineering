public class FindSubstring {

    public static int findSubString(String txt, String pat) {
        int txtLength = txt.length();
        int patLength = pat.length();

        for (int i = 0; i <= txtLength - patLength; i++) {
            int j;
            for (j = 0; j < patLength; j++) {
                if (txt.charAt(i + j) != pat.charAt(j)) {
                    break;
                }
            }
            if (j == patLength) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String txt = "geeksforgeeks";
        String pat = "eks";
        System.out.println(findSubString(txt, pat));
    }
}
