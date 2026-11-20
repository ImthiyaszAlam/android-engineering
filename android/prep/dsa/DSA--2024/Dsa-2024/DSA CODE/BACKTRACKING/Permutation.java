public class Permutation {

    public static void printPermutation(String str,String ans){
        if (str.length() ==0) {
            System.out.println(ans);
            return;
        }
        for(int i=0;i<str.length();i++){
            char currentChar = str.charAt(i); //a
            String newString = str.substring(0, i)+str.substring(i+1); //bc
            printPermutation(newString, ans+currentChar);
        }
    }
    public static void main(String[] args) {
        String str = "abc";
        String currentChar = "";
        printPermutation(str, currentChar);
    }
}
