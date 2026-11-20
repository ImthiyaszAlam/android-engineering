public class printIncreasing {

    public static void printIncres(int start,int end) {
        if (start == end) {
            System.out.println(end);
            return;
        }
        System.out.print(start+" ");
        printIncres(start + 1,end);
    }

    public static void main(String[] args) {
        int start = 1;
        int end = 100;
        printIncres(start,end);
    }
}
