public class EvenOddDigits {

    static class DigitCounts {

        int oddCount;
        int evenCount;

        DigitCounts(int oddCount, int evenCount) {
            this.evenCount = evenCount;
            this.oddCount = oddCount;
        }

        @Override
        public String toString() {
            return evenCount + " " + oddCount;
        }

    }

    public static DigitCounts digitCountss(int a) {

        int oddCount = 0;
        int evenCount = 0;
        while (a != 0) {
            int digit = a % 10;
            if (digit % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
            a = a / 10;
        }
        return new DigitCounts(evenCount, oddCount);

    }

    public static void main(String[] args) {
        int num = 123456;
        System.out.println(digitCountss(num));
    }
}
