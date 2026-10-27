import java.util.HashSet;
import java.util.Set;

public class Duplicate {
    public static void main(String[] args) {
        String str = "annanjk";
        Set<Character> set = new HashSet<>();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if (!set.contains(c)) {
                set.add(c);
                sb.append(c);
            }
        }
        System.out.println(sb.toString());


    }
}
