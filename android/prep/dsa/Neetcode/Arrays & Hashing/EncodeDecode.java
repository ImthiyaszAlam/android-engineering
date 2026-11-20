import java.util.ArrayList;
import java.util.List;

public class EncodeDecode {

    public static String encode(String strs[]) {

        StringBuilder encodedList = new StringBuilder();

        for (int i = 0; i < strs.length; i++) {
            String currentWord = strs[i];
            int currentWordLength = currentWord.length();
            String currentWordToEncode = currentWord + currentWordLength + "#";
            encodedList.append(currentWordLength).append("#").append(currentWord);
        }

        return encodedList.toString();
    }

    public static void main(String[] args) {

        String strs[] = { "apple", "banana", "grapes", "jamun" };
        System.out.println(encode(strs));

    }
}
