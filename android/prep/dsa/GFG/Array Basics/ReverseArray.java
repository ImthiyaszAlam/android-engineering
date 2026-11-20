import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseArray {

    public static void reverseArrayTwoPointer(int[] arr){
        int n = arr.length;
        int left = 0;
        int right = n-1;


        while (left<right) {
            int temp =arr[left];
            arr[left] = arr[right];
            arr[right]=temp;
            
        left++;
        right--;
        }
    }

    public static void reverseArray(int arr[]) {
        int n = arr.length;
        int tempArr[] = new int[n];

        for (int i = 0; i < n; i++) {
            tempArr[i] = arr[n - i - 1];
        }
        for (int i = 0; i < n; i++) {
            arr[i] = tempArr[i];
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 13, 4, 2, 11, 6 };

        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8));
        Collections.reverse(list);
        reverseArrayTwoPointer(arr);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ",");
        }
    }
}
