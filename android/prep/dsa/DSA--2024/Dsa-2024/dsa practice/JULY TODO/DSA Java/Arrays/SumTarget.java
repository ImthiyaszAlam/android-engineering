import java.util.Arrays;

public class SumTarget {
    public static void main(String[] args) {
        int a[] = { 10, 0, 7, 0, 10, 5, 5, 3, 7, 8, 2, 3 };
        int target = 10;
        int low = 0;
        int high = a.length - 1;
        Arrays.sort(a);

        while (low < high) {
            if (a[low] + a[high] > target) {
                high--;
            } else if (a[low] + a[high] < target) {
                low++;
            } else if (a[low] + a[high] == target) {
                System.out.print("pair is: " + a[low] + "  " + a[high]+"  ");
                if (a[low] == a[high]) {
                    System.out.println("a duplicate pair: " + a[low] + " " + a[high]);
                }
                low++;
                high--;
            } else {
                System.out.println("pair doesn't exist");
            }
        }
        String result = Arrays.toString(a);
        System.out.println(result);
    }
}
