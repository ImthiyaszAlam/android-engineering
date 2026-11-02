public class MinimumSwap {

    static int swapCount(String str) {
        int ans = 0;
        int count = 0;
        int n = str.length();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '[') {
                count++;
            } else {
                count--;
            }

            if (count < 0) {
                int j = i + 1;
                while (j < n) {
                    if (str.charAt(j) == '[') {
                        break;
                    }
                    j++;
                }
                ans += j - i;

                count = 1;
                char ch = str.charAt(j);
                StringBuilder newString = new StringBuilder(str);
                for (int k = j; k > i; k++) {
                    if (k - 1 < 0 || k >= n) break;

                    newString.setCharAt(k, str.charAt(k - 1));
                }

                newString.setCharAt(i, ch);
                str = newString.toString();
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "[]][][";
        System.out.println(swapCount(s));

    }
}
