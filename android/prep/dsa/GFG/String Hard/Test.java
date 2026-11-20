import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 1, 4, 1, 3, 1, 4 };

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    System.out.println(arr[i]);
                }
            }
        }
    }
}
