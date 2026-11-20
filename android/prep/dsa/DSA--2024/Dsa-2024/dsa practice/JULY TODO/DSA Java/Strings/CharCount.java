public class CharCount {
    public static void main(String[] args) {
        String str = "my name is alam";
        char strArr[] = str.toCharArray();

        for (int i = 0; i < strArr.length; i++) {
            StringBuilder currentWord = new StringBuilder();
            while (i<strArr.length && strArr[i]!=' ') {
                currentWord.append(strArr[i]);
                i++;
            }
            System.out.println(currentWord+"  --->: "+currentWord.length());
        }
    }
}
