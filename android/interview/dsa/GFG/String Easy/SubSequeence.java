public class SubSequeence {

    public static boolean isSubsequence(String s1, String s2) {
        int s1Pointer = 0;
        int s2Pointer = 0;
        int s1Length = s1.length();
        int s2Length = s2.length();

        while (s1Pointer < s1Length && s2Pointer < s2Length) {
            if (s1.charAt(s1Pointer) == s2.charAt(s2Pointer)) {
                s1Pointer++;
             
            }
            s2Pointer++;
        }
        return s1Pointer == s1Length;

    }

    public static void main(String[] args) {
        String s1 = "gksrek";
        String s2 = "geeksforgeeks";
        if (isSubsequence(s1, s2)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
