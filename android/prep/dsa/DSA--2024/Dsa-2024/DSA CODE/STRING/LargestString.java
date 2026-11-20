public class LargestString {

    public static void printLargestString(String str) {

    }

    public static void main(String[] args) {
        String fruits[] = { "orang", "banana", "mango" };
        String largest = fruits[0];
        for (int i = 1; i < fruits.length; i++) {
            if (largest.compareTo(fruits[i]) < 0) {
                largest = fruits[i];
            }
        }
        System.out.println("largest string is " + largest);
    }
}
