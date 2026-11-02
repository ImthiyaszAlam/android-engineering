import java.util.Arrays;

/**
 * Merge
 */
public class Merge {

    public static void main(String[] args) {
        int a[] = { 1, 4, 2, 6, 5 };
        int b[] = { 8, 5, 3, 7 };
        int l1 = a.length;
        int l2 = b.length;

        int c[] = new int[l1 + l2];

        int i = 0, j = 0, k = 0;

        while (i < l1 && j < l2) {
            if (a[i] < b[j]) {
                c[k++] = a[i++];
            } else {
                c[k++] = b[j++];
            }
        }

        while (i < l1) {
            c[k++] = a[i++];
        }
        while (j < l2) {
            c[k++] = b[j++];
        }
        Arrays.sort(c);
        System.out.println(Arrays.toString(c));

    }
}