public class Concat {

    public static String concatSb(String s1, String s2) {
        StringBuilder result = new StringBuilder();

        for (char ch : s1.toCharArray()) {
            result.append(ch);
        }

        for (char ch : s2.toCharArray()) {
            result.append(ch);
        }

        return result.toString();

    }

    public static String concat(String s1, String s2) {
        String result;
        result = s1 + s2;
        return result;
    }

    public static void main(String[] args) {
        String s1 = "Al";
        String s2 = "am";
        System.out.println(concatSb(s1, s2));
    }
}
