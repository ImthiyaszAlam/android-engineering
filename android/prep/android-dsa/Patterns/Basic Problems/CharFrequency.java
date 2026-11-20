import java.util.HashMap;

public class CharFrequency {

    public static void countFrequency(String str) {

        HashMap<Character, Integer> frequency = new HashMap<>();

        for (char ch : str.toCharArray()) {
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }
        System.out.println(frequency);

    }

    public static void main(String[] args) {
        String str = "malayalam";
        countFrequency(str);
    }
}
