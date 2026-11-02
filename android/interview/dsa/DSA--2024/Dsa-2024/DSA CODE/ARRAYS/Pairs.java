public class Pairs {

    public static void printPairs(int a[]) {
        int tp = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length - 1; j++) {
                int currentNum = a[i];
                int secondNum = a[j];
                System.out.print("(" + currentNum + " " + secondNum + ")");
                tp++;
            }
            System.out.println();
        }
        System.out.println("total pairs: " + tp);
    }
    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        printPairs(a);
    }
}
