import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static int[] twoSum(int arr[], int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int twoSum[] = new int[2];

        for (int i = 0; i < arr.length; i++) {
            int currentElement = arr[i];
            int elementShouldBe = target - currentElement;
            if (map.containsKey(elementShouldBe)) {
                return new int[] { map.get(elementShouldBe), i };
            }
            map.put(currentElement, i);
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        int arr[] = { 2, 7, 11, 15 };
        int result[] = twoSum(arr, 9);
        System.out.println(Arrays.toString(result));

    }
}