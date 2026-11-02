import java.util.List;
import java.util.Map;

public class SubstringWithConcatenation {

    public List<Integer> findSubstring(String inpuString, String words[]) {

        List<Integer> startingIndices = new ArrayList<>();

        if (inpuString == null || inpuString.isEmpty() || words.length == 0) {
            return startingIndices;
        }

        int wordLength = words[0].length();
        int totalWordLength = wordLength * words.length;

        Map<String, Integer> targetWordFrequency = new HashMap<>();

        for (String w : words) {
            targetWordFrequency.put(w, targetWordFrequency.getOrDefault(w, 0) + 1);
        }

        for (int offSet = 0; offSet < wordLength; offSet++) {
            int windowStart = offSet;
            int windowEnd = offSet;
            int wordsMatchedCount = 0;

            Map<String, Integer> currentWordFrequency = new HashMap<>();

            while (windowEnd + wordLength <= inpuString.length()) {
                String currentWord = inpuString.substring(windowEnd, windowEnd + wordLength);
                windowEnd += wordLength;

                if (targetWordFrequency.containsKey(currentWord)) {
                    currentWordFrequency.put(currentWord, currentWordFrequency.getOrDefault(currentWord, 0) + 1);
                    wordsMatchedCount++;

                    while (wind.get(currentWord) > targetWordFrequency.get(currentWord)) {
                        String wordAtWindowStart = inpuString.substring(windowStart, windowStart + wordLength);
                        currw
                    }
                }
            }

        }

    }

    public static void main(String[] args) {

    }
}