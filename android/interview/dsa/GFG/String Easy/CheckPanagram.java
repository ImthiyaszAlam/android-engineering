public class CheckPanagram {

    public static boolean idPanagram(String str) {
        for (char currentChar = 'a'; currentChar <= 'z'; currentChar++) {

            boolean found = false;
            for (int i = 0; i < str.length(); i++) {
                if (currentChar == Character.toLowerCase(str.charAt(i))) {
                    found = true;
                    break;
                }
            }
            if (found == false) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        String str = "The quick brown fox jumps over the lazy";
        System.out.println(idPanagram(str));

    }
}
