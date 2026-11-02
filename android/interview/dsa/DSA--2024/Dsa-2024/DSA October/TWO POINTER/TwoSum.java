import java.util.ArrayList;
import java.util.List;

public class TwoSum {

    public static boolean findTwoSum(int arr[], int targetSum) {

        List<String> allPairs = new ArrayList<>();
        int sum = 0;
        boolean found = false;
        // generate all possible pairs from given array
        // to generate all possible pairs we can run two nested for loops
        int j;
        // fist start from zeroth index and get first elemend
        for (int i = 0; i < arr.length; i++) {

            // from second loop add second element after first element to make it a pair
            for (j = i + 1; j < arr.length; j++) {
                sum = arr[i] + arr[j];
                // check if those elements from each pair adds up and is equal to target
                if (sum == targetSum) {
                    allPairs.add("(" + arr[i] + " " + arr[j] + ")");
                    found = true;
                }
            }
        }
        if (found) {
            System.out.println(allPairs);
        } else {
            System.out.println("No pairs found");
        }

        return found;
    }

    public static boolean findTwoSumOptimized(int arr[], int target) {
        int n = arr.length;
        int sum = 0;
        boolean foundElement = false;
        List<String> resultPairs = new ArrayList<>();

        int left = 0;
        int right = n - 1;
        while (left < right) {
            sum = arr[left] + arr[right];
            if (sum == target) {
                resultPairs.add("(" + arr[left] + " " + arr[right] + ")");
                foundElement = true;

                left++;
                right--;

            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        if (foundElement) {
            System.out.println("pairs with target sum: " + resultPairs);
        } else {
            System.out.println("No element found");
        }

        return foundElement;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int target = 9;
        findTwoSumOptimized(arr, target);

    }
}