import java.util.Arrays;

public class SegregateOneZero {
    public static void main(String[] args) {
        int a[] = { 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1 };
        int left = 0;
        int right = a.length - 1;
        while (left < right) {
            if (a[left] == 0) {
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
                right--;
            } else {
                left++;
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
