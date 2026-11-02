import java.util.Arrays;

// from given two arrays make pairs in such  a way that sum of their absolute differences is minimum

public class AbsoluteDiff {

    // TC O(nlogn)
    public static void main(String[] args) {
        int arr1[] = { 1, 2, 3 };
        int arr2[] = { 2, 5, 3 };

        // Sort this two arrays
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // 1,2,3
        // 2,3,5
        int minDifference = 0;
        for (int i = 0; i < arr1.length; i++) {
            minDifference += Math.abs(arr1[i] - arr2[i]);
        }
        System.out.println(minDifference);
    }
}
