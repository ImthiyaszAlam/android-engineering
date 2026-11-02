public class AreRotation {

    public static boolean areRotation(String s1, String s2) {

        if (s1.equals(s2)) {
            return true;
        }

        for (int i = 0; i < s1.length(); i++) {
            char lastChar = s1.charAt(s1.length() - 1);
            s1 = lastChar + s1.substring(0, s1.length() - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "alam";
        String s2 = "amal";
        System.out.println(areRotation(s1, s2));

    }
}
