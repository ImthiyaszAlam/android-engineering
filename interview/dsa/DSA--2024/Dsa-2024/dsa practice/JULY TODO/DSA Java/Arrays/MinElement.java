public class MinElement {
    public static void main(String[] args) {
        int a[] = { 2, 13, 14, 13, 1, 2, 3, 4, 5, 6, 7 };
        int minElement = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] < minElement) {
                minElement = a[i];
            }
        }
        System.out.println("min element is: " + minElement);
    }
}
