import java.util.Arrays;

public class Bubbling {
    public static void main(String[] args) {
        int arraElements[] = { 400, 59, 20, 100, 10, 1, 15, 20, 8, 3, 40 };
        for (int i = 0; i < arraElements.length; i++) {
            for (int j = 0; j < arraElements.length - 1 - i; j++) {
                if (arraElements[j] < arraElements[j + 1]) {
                    int temp = arraElements[j];
                    arraElements[j] = arraElements[j + 1];
                    arraElements[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arraElements));

    }
}
