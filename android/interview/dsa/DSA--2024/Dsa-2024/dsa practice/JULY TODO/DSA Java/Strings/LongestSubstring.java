import java.util.HashSet;

public class LongestSubstring {
    public static void main(String[] args) {
        String str = "abcdab";
        HashSet<Character>set = new HashSet<>();
        String longestOverall = "";
        String longestTillNow = "";

        for(int i=0;i<str.length();i++){
            char currentChar = str.charAt(i);
            if (set.contains(currentChar)) {
                longestTillNow = " ";
                set.clear();
            }else{
                longestOverall+=currentChar;
                set.add(currentChar);
            }
            if (longestTillNow.length()>longestOverall.length()) {
                longestOverall = longestTillNow;
            }
        }
        System.out.println("longestOverall: "+longestOverall);
        System.out.println("longestTillNow: "+longestOverall);
       
    }
}
