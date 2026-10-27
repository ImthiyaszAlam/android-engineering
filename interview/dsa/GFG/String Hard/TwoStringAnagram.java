public class TwoStringAnagram {

    static int remAnagram(String s1, String s2) {
        int count1[] = new int[26];
        int count2[] = new int[26];

        for (char ch : s1.toCharArray()) {
            count1[ch - 'a']++;
        }

        for (char ch : s2.toCharArray()) {
            count2[ch - 'a']++;
        }

        int ans = 0;
        for(int i=0;i<26;i++){
            ans+=Math.abs(count1[i]-count2[i]);
        
        }
        return ans;
    }

    public static void main(String[] args) {
        String s1 = "alam";
        String s2 = "malam";
        System.out.println(remAnagram(s1, s2));
    }
}
