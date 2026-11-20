public class PalindromeSentence {

    public static boolean isPaliSen(String sentence) {
        int left = 0;
        int right = sentence.length() - 1;

        while (left <= right) {
            if (!Character.isLetterOrDigit(sentence.charAt(left))) {
                left++;
            } else if (!Character.isLetterOrDigit(sentence.charAt(right))) {
                right--;
            } else if (Character.toLowerCase(sentence.charAt(left)) == Character.toLowerCase(sentence.charAt(right))) {
                left++;
                right--;

            } else {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        String sentence = "Too hot to hoot.";
        System.out.println(isPaliSen(sentence));
    }
}
