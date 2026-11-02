public class SubArray {

    public static void printSubarray(int num[]) {

        int ts = 0;
        for (int i = 0; i < num.length - 1; i++) {
            int start = num[i];
            for (int j = i; j < num.length - 1; j++) {
                int end = num[j];
                for (int k = start; k <= end; k++) {
                    System.out.print(num[k] + " ");

                }
                ts++;
                System.out.println();
            }
            System.out.println();
            System.out.println("total sub array :"+ts);
        }
    }

    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        printSubarray(a);

    }
}
