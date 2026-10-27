public class LetterCount {
    public static void main(String[] args) {
        String str = "anna alam";

        char[] currentArray = str.toCharArray();
        for (int i = 0; i < currentArray.length; i++) {
            String s1 = "";
            while (i < currentArray.length && currentArray[i] != ' ') {
                s1 = s1 + currentArray[i];
                i++;
            }
            if (s1.length() > 0) {
                System.out.print(s1 + " " + s1.length() + " ");
            }
        }
    }
}
