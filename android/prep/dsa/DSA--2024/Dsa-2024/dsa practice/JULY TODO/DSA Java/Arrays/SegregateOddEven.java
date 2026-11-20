import java.util.Arrays;

public class SegregateOddEven {
    public static void main(String[] args) {
        int a[] = { 1,0,0,0,0,1,1,1,1,0,1,0,1,0};
        // int left = 0;
        // int right = a.length - 1;

        // while (left < right) {
        //     if (a[left] % 2 == 0) {
        //         // even
        //         int temp = a[left];
        //         a[left] = a[right];
        //         a[right] = temp;
        //         right--;
        //     } else {
        //         left++;
        //     }
        // }
        
        // String arr = Arrays.toString(a);
        // System.out.println(arr);

        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
