import java.util.Scanner;

public class Even {

    public static boolean isEven(int num) {
        if (num % 2 != 0) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {

        int num = 5;
        System.out.println(isEven(num));

    }
}
