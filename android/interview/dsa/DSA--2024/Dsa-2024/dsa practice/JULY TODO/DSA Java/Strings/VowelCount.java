import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VowelCount {

    public static boolean isVowel(char ch) {
        ch = Character.toUpperCase(ch);
        return (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U');
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String");
        String str = sc.next();
        int vowelCount = 0;
        int consonantCount = 0;
        List<Character>vowels = new ArrayList<>();
        List<Character>consonants = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isLetter(ch)) {
                if (isVowel(ch)) {
                    vowelCount++;
                    vowels.add(ch);
                } else {
                    consonantCount++;
                    consonants.add(ch);
                }
            }
        }
        System.out.print("vowel count: " + vowelCount);
        System.out.println("   -> vowels: " + vowels);
        System.out.print("consonant count: " + consonantCount);
        System.out.println("  ->  consonants: " + consonants);
    }
}
