import java.util.ArrayList;
import java.util.List;

public class FindSubString {

    public static List<String> findSubstring(String str) {

        List<String> result = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < str.length() - 1; i++) {
            for (int j = i; j < str.length(); j++) {
                result.add(str.substring(i, j + 1));
                count++;
            }
        }
        System.out.println(count);
        
        return result;
    }

    public static void main(String[] args) {
        String str = "alam";
        System.out.println(findSubstring(str));
    }
}
