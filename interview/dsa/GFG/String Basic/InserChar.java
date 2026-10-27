public class InserChar {

    public static String insertChar(String str, int pos, char ch) {
        StringBuilder sBuilder = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (i == pos) {
                sBuilder.append(ch);
            }
            sBuilder.append(str.charAt(i));
        }
        if (pos >= str.length()) {
            sBuilder.append(ch);
        }
        return sBuilder.toString();
    }

    public static void main(String[] args) {
        String str = "code";
        int pos = 3;
        char ch = 'N';
        System.out.println(insertChar(str, pos, ch));
    }
}
