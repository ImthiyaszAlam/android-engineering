import java.util.Arrays;

public class TwoSum1 {
    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
        Arrays.sort(a);
        int len = a.length;
        int firstElement = a[0];
        int targetSum = 10;
        int lastElement = a[len - 1];
        while (firstElement <= lastElement) {
            int sum = firstElement + lastElement;
            if (sum == targetSum) {
                System.out.println(firstElement + " " + lastElement);
                firstElement++;
                lastElement--;
            } else if (sum > targetSum) {
                lastElement--;
            } else {
                firstElement++;
            }
        }

    }
}
