import java.util.Arrays;

public class SegregateZeroOne {
    public static void main(String[] args) {
        int a[] = { 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1 };
        int left = 0;
        int right = a.length - 1;
        while (left < right) {
            if (a[left] == 0) {
                left++;
            } else {
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
                right--;
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
