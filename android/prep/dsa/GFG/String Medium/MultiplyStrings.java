public class MultiplyStrings {

    public static String multiplyStrings(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();

        if (n1 == 0 || n2 == 0)
            return "0";

        int sign = 1;
        if (s1.charAt(0) == '-') {
            sign *= -1;
            s1 = s1.substring(1);
            n1--;
        }
        if (s2.charAt(0) == '-') {
            sign *= -1;
            s2 = s2.substring(1);
            n2--;
        }

        int[] result = new int[n1 + n2];

        // multiply each digit
        for (int i = n1 - 1; i >= 0; i--) {
            int carry = 0;
            int n1Digit = s1.charAt(i) - '0';

            for (int j = n2 - 1; j >= 0; j--) {
                int n2Digit = s2.charAt(j) - '0';
                int sum = n1Digit * n2Digit + result[i + j + 1] + carry;
                carry = sum / 10;
                result[i + j + 1] = sum % 10;
            }
            result[i] += carry;
        }

        // convert to string
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < result.length && result[i] == 0)
            i++;

        if (i == result.length)
            return "0";

        for (; i < result.length; i++)
            sb.append(result[i]);

        if (sign == -1)
            sb.insert(0, '-');

        return sb.toString();
    }

    public static void main(String[] args) {
        String s1 = "-10";
        String s2 = "10";
        System.out.println(multiplyStrings(s1, s2));  
    }
}
