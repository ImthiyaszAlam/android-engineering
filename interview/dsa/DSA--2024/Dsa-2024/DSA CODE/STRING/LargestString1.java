public class LargestString1 {

    public static void printLargestStr(String str[]) {
        String largest = str[0];
        for (int i = 0; i < str.length - 1; i++) {
            if (largest.compareToIgnoreCase(str[i]) < 0) {
                largest = str[i];
            }
        }
        System.out.println(largest);
    }

    public static void main(String[] args) {
        String fruits[] = { "banana", "mango", "grapes" };
        printLargestStr(fruits);
    }
}
