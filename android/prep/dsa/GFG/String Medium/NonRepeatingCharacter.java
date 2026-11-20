public class NonRepeatingCharacter {

    public static char kthNonRepeatingChar(String str, int k) {

        int count = 0;
        char result = '$';
        for (int i = 0; i < str.length(); i++) {

            boolean repeated = false;
            for (int j = 0 ; j < str.length(); j++) {
                if (i != j && str.charAt(i) == str.charAt(j)) {
                    repeated = true;
                    break;
                }
            }

            if (!repeated) {
                count++;
                if (count == k) {
                    result = str.charAt(i);
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "alam";
        int k = 2;
        System.out.println(kthNonRepeatingChar(str, k));
    }
}
