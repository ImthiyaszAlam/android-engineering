import java.util.Scanner;

public class EvenOddArray {

    public static void evenOddArray(int arr[]) {
        int odd[] = {};
        int even[] = {};
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] % 2 == 0) {
                even[i] = arr[i];
            } else {
                odd[i] = arr[i];
            }
        }
        for (int i = 0; i < odd.length - 1; i++) {
            System.out.println(odd[i] + " ");
        }
        for (int i = 0; i < even.length - 1; i++) {
            System.out.println(odd[i] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter size ");
        int size = sc.nextInt();
        int num[] = new int[size];
        for (int i = 0; i < size; i++) {
            num[i] = sc.nextInt();
        }

        System.out.println(evenOddArray(num););

    }
}
