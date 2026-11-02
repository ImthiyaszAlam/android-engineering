import java.util.Arrays;

public class ZeroOneCount {
    public static void main(String[] args) {
        int arr[] = { 0, 1, 1, 2, 2, 0, 1, 0, 1, 2 };
        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;

        // Count the number of zeros, ones, and twos
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                zeroCount++;
            } else if (arr[i] == 1) {
                oneCount++;
            } else {
                twoCount++;
            }
        }

        System.out.println("zeroCount: " + zeroCount);
        System.out.println("oneCount: " + oneCount);
        System.out.println("twoCount: " + twoCount);

        // Initialize newArr with the same size as arr
        int newArr[] = new int[arr.length];

        // Fill newArr with zeros followed by ones and then twos
        for (int i = 0; i < zeroCount; i++) {
            newArr[i] = 0;
        }
        for (int i = zeroCount; i < zeroCount + oneCount; i++) {
            newArr[i] = 1;
        }
        for (int i = zeroCount + oneCount; i < zeroCount + oneCount + twoCount; i++) {
            newArr[i] = 2;
        }

        System.out.println(Arrays.toString(newArr));
    }
}
