public class LongestPalindromicString {

    static boolean checkPal(String str,int low,int high){
        while (low<high) {
            if (str.charAt(low)!=str.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }

        return true;
    }



    static String longestPalindrome(String str){

        int n= str.length();
        int maxLen = 1;
        int start = 0;

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if (checkPal(str, i, j) && (j-i+1)>maxLen) {
                    start = i;
                    maxLen = j-i+1;
                }
            }
        }

        return str.substring(start, start+maxLen);
    }


    public static void main(String[] args) {
        String str = "forgeeksskeegfor";
        System.out.println(longestPalindrome(str));
    }
}
