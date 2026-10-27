public class LargestDivisor {
    public static void main(String[] args) {
        String s1 = "ABCABC";
        String s2 = "ABC";

        int l1 = s1.length();
        System.out.println("length Str1 ; " + l1);
    
        String largestDividingString = "";
        String substring ;
  

        for(int i=1; i<=s1.length(); i++){
            substring = s1.substring(0, i); 

            if (s1.length() % substring.length() == 0 && s2.length() % substring.length() == 0 && s1.replaceAll(substring,"").isEmpty()  && s2.replaceAll(substring,"").isEmpty()) {
                largestDividingString = substring;
                
            }
        }
        System.out.println(largestDividingString);
    }
}
