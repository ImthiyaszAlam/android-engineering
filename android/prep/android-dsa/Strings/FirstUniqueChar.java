public class FirstUniqueChar {

    public static int firstUniqueChar(String str) {

        for (int i = 0; i < str.length(); i++) {

            int count = 0;

            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    count++;
                }
            }

            if (count == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        String str = "alam";
        int result = firstUniqueChar(str);
        System.out.println(result);
    }
}
