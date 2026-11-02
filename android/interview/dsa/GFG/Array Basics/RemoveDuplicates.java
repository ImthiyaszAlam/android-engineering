import java.util.HashSet;

public class RemoveDuplicates {

    static int removeDuplicates(int arr[]) {
        HashSet<Integer> set = new HashSet<>();

        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!set.contains(arr[i])) {
                set.add(arr[i]);
                arr[idx++] = arr[i];
            }
        }
        return idx;
    }

    public static void main(String[] args) {

        int arr[] = { 1, 2, 2, 3, 4, 4, 4, 5, 5, 6,7 };
        int size = removeDuplicates(arr);
        for (int i = 0; i < size; i++) {
            System.out.println(arr[i] + " ");
        }
    }
}
