public class Reverse {

    public static void main(String[] args) {

        String str = "Alam";
        String rStr = reverseString(str);
        System.out.println(rStr);
    }

    public static String reverseString(String str) {
        char[] charArray = str.toCharArray();
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            char temp = str.charAt(left);
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }

        return new String(charArray);

    }
}