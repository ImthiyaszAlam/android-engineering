public class PrimeNumber {

    public static boolean isPrime(int num) {
        int factor = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                factor++;
            }
        }
        if (factor == 2) {
            return true;
        } else {
            return false;
        }
    }

    public static void countAndSumPrimes(int start, int end) {
        int count = 0;
        int sum = 0;
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                count++;
                sum += i;
            }
        }
        System.out.println("total prime number from "+ start + " to "+end+" is " +count );
        System.out.println("total prime number from "+ start + " to "+end+" is " +sum );
    }

    public static void main(String[] args) {
        int start = 10;
        int end = 100;
        countAndSumPrimes(start, end);
    }
}
