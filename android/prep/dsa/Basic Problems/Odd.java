public class Odd {

    public static boolean isOdd(int num) {

        if (num % 2 == 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

        int num = 4;
        System.out.println(isOdd(num));

    }
}
