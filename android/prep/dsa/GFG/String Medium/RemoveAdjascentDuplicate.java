public class RemoveAdjascentDuplicate {

    public static String removeAdjascent(String str) {
        StringBuilder result = new StringBuilder();
        int n = str.length();

        for (int i = 0; i < n; i++) {
            boolean isRepeated = false;

            while (i + 1 < n && str.charAt(i) == str.charAt(i + 1)) {
                isRepeated = true;
                i++;
            }

            if (!isRepeated) {
                result.append(str.charAt(i));
            }
        }

        if (n == result.length()) {
            return result.toString();
        }

        return removeAdjascent(result.toString());

    }

    public static void main(String[] args) {
        String str = "aalam";
        System.out.println(removeAdjascent(str));
    }
}
