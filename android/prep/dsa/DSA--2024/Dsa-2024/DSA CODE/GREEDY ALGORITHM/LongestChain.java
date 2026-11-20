import java.util.Arrays;
import java.util.Comparator;

public class LongestChain {
    public static void main(String[] args) { // o(nlogn)
        int pairs[][] = { { 5, 24 }, { 39, 60 }, { 5, 28 }, { 27, 40 }, { 50, 90 } };

        int chainLen = 1;

        // sorting based on second cols which is second number in each pair o[1]
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        int chainEnd = pairs[0][1]; // chainEnd at zeroth index
        for (int i = 1; i < pairs.length; i++) {
            // check if next chain's first number is greater than previous pairs's second
            // number
            if (pairs[i][0] > chainEnd) {
                chainLen++;
                chainEnd = pairs[i][1]; // chainend at ith index
            }
        }
        System.out.println(chainLen);
    }
}
