import java.util.ArrayList;

public class Alternate {

    public static void main(String[] args) {

        int [] arr = {1,2,3,4,5,6,7,8};
        System.out.println(returnAlternate(arr));
    }

    static ArrayList<Integer> returnAlternate(int[] arr) {

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i += 2) {
            result.add(arr[i]);
        }

        return result;
    }
}
