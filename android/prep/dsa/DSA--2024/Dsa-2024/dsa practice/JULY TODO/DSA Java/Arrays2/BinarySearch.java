import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int a[] = { 1, 2, 2, 33, 4, 55, 64, 87, 23 };
        Arrays.sort(a);
        int element = 55;
        int start = 0;
        int end = a.length - 1;
        boolean isFound = false;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (element == a[mid]) {
                System.out.println("element is found at index: " + mid + " elemnt is " + a[mid]);
                isFound = true;
                break;
            } else if (element < a[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (!isFound) {
            System.out.println("element is not found");
        }
    }
}
