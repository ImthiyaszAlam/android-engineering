
public class Subset {
    public static void findSubsets(String str, String ans, int currentChar) {
        if (currentChar == str.length()) {
            System.out.print(ans+" ");
            return;
        }
        findSubsets(str, ans + str.charAt(currentChar), currentChar+1);
        findSubsets(str, ans, currentChar+1);
    }

    public static void main(String[] args) {
        String str = "abc";
        findSubsets(str, "", 0);

    }
}
