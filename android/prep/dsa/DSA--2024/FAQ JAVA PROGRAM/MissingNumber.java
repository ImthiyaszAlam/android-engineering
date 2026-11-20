public class MissingNumber {

    public static void findMissingNumer(int a[]) {
        int missingNumber = 0;

        int sum = 0;
        int totalSum = 0;
        for (int i = 1; i < 5; i++) {
            sum += a[i];
        }
        for (int j = 0; j < a.length; j++) {
            totalSum += j;
        }
        missingNumber = totalSum - sum;
        System.out.println(missingNumber);

    }

    public static void main(String[] args) {
        int num[] = {1,2,4,5};
        findMissingNumer(num);
    }
}
