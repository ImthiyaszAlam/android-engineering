public class FirstRepeatingNonChar {

    public static char firstNonRepeat(String str) {

        for (int i = 0; i < str.length(); i++) {
            boolean found = false;

            for (int j = 0; j < str.length(); j++) {
                if (i != j && str.charAt(i) == str.charAt(j)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return str.charAt(i);
            }
        }
        return '$';
    }

    public static void main(String[] args) {
        String str = "alalm";
        System.out.println(firstNonRepeat(str));
    }
}
