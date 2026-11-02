public class AddTwoBinary {

    public static String trimLeadingZaros(String str) {
        int firstOne = str.indexOf('1');
        return (firstOne == -1) ? "0" : str.substring(firstOne);
    }

    public static String addTwoBinary(String s1, String s2) {
        s1 = trimLeadingZaros(s2);
        s2 = trimLeadingZaros(s2);

        if (s1.length() < s2.length()) {
            return addTwoBinary(s2, s1);
        }

        int j = s2.length() - 1;
        int carry = 0;

        StringBuilder result = new StringBuilder();
        for (int i = s1.length() - 1; i >= 0; i--) {
            int bit1 = s1.charAt(i) - '0';
            int sum = bit1 + carry;

            if (j >= 0) {
                int bit2 = s2.charAt(j) - '0';
                sum += bit2;
                j--;
            }

            int bit = sum % 2;
            carry = sum / 2;

            result.append((char) (bit + '0'));
        }

        if (carry > 0) {
            result.append('1');
        }

        return result.reverse().toString();
    }

    static String addBinary(String[] str) {
        String res = "0";
        for (int i = 0; i < str.length; i++) {
            res = addTwoBinary(res, str[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        String str[] = { "1", "11", "111" };
        System.out.println(addBinary(str));
    }
}
