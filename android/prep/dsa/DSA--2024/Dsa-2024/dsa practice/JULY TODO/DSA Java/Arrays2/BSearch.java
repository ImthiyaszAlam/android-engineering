import java.util.Arrays;

public class BSearch {
    public static void main(String[] args) {
        int a[] = { 10, 12, 1, 11, 141, 3 };
        Arrays.sort(a);
        int targetElement = 10;
        int start = 0;
        int end = a.length - 1;
        int mid = (start + end) / 2;
        boolean found = false;

        while (start <= end) {
            if (targetElement == a[mid]) {
                found = true;
                System.out.println("element is found at index : " + mid);
                break;
            } else if (targetElement < a[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (!found) {
            System.out.println(targetElement + " is not present in array");
        }
    }
}
