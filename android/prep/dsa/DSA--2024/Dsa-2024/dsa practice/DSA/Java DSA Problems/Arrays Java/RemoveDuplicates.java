import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

    public static Integer[] removeDuplicatesSet(int[] inputArray) {
        Set<Integer> set = new HashSet<Integer>();
        for (int element : inputArray) {
            set.add(element);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] originalArray = { 1, 2, 3, 4, 1, 2, 5, 6 };
        Integer[] arrayWDuplicate = removeDuplicatesSet(originalArray);

    }
}
