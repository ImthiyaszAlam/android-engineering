public class OddEvenCount {

    public static void main(String[] args) {
        int number = 123456;
        int evenCount = 0;
        int oddCount = 0;

        while (number>0) {
            int lastDigit = number/10;
            if (lastDigit %2 ==0) {
                evenCount++;
            }

            else{
                oddCount++;
            }

            number = number/10;
        }

        System.out.println("Odd Number:"+ oddCount+"Even Number:"+evenCount);
    }
}