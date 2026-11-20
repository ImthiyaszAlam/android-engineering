public class Repeating1toNm1 {

    public static int findRepeating(int arr[]) {

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return arr[i];
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 3 };
        int n = arr.length - 1;
        int actualSum = 0;
        int expectedSum = n * (n + 1) / 2;

        for (int i : arr) {
            actualSum += i;
        }

        System.out.println("Repeating number is:" + findRepeating(arr));

    }
}
