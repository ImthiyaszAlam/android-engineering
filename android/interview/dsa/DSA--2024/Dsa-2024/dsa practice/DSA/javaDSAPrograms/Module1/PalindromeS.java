public class PalindromeS {
    public static void main(String[] args) {
        String str = "AAA";
        String reversed = "";

        for(int i =str.length()-1;i>=0;i--){
            reversed = reversed+str.charAt(i);
        }

        if (str.equals(reversed) ) {
            System.out.println("Palindrome String"+reversed);
        }
        else{
            System.out.println("Not Palindrome");
        }
    }
}
