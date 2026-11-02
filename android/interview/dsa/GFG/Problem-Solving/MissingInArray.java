import java.util.Arrays;

public class MissingInArray {

    static int findMissing(int[] arr) {

        int n = arr.length + 1;
        Arrays.sort(arr);
        long arraySum =(long) n * (n + 1) / 2;
        System.out.println("arraySum: "+arraySum);
        long actualSum = 0;

        System.out.println("actualSum: "+arraySum);
        for (int i = 0; i < arr.length; i++) {
            actualSum += arr[i];
        }

        int missing = (int) (arraySum - actualSum);
        return missing;

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 5 };
        System.out.println(findMissing(arr));
    }
}
