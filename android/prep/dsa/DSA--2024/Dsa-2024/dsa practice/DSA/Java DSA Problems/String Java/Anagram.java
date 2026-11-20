public class Anagram {

    public static boolean isAnagram(String s1,String s2) {
       int[]count = new int[256];
       for(int i=0;i<s1.length();i++){
        count[s1.charAt(i)]++;
        count[s2.charAt(i)]--;
       }
       for(int i=0;i<count.length;i++){
        if (count[i]!=0) {
            return false;
        }
       }
       return true;
    }
    public static void main(String[] args) {
        String s1 = "aab";
        String s2 = "aba";
        Anagram a  = new Anagram();
        a.isAnagram(s1, s2);
    }


}
