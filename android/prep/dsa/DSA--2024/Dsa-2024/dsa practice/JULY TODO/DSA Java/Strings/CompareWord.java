public class CompareWord {
    public static void main(String[] args) {
        String str1 = "anna";
        String str2 = "annaa";
        boolean isCompare = false;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                isCompare =  false;
            }
            isCompare = true;
        }
        System.out.println("both the strings are equal  : "+isCompare);
    }
}
