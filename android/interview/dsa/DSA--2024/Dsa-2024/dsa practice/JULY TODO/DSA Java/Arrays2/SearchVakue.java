/**
 * SearchVakue
 */
public class SearchVakue {

    public static void main(String[] args) {
        int a[] = { 2, 3, 4, 6, 8, 10 };
        int element = 6;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == element) {
                System.out.println("index of element is:" + i);
                break;
            }
        }
    }
}