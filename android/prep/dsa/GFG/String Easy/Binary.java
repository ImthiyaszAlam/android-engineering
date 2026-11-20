public class Binary {

    public static boolean isBinary(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '0' && str.charAt(i) != '1') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "0100001";
        System.out.println(isBinary(str));
    }
}