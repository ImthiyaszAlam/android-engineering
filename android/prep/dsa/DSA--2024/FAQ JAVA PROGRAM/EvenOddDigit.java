public class EvenOddDigit {

    public static int evenAndOddDigitCount(int a ){
        int oddCount = 0;
        int evenCount = 0;
        while (a!=0) {
            int digit = a/10;
            if (digit%2 == 0) {
                evenCount++;
            }else{
                oddCount++;
            }
            a = a/10;
        }
        return evenCount;
        
        
    }
    public static void main(String[] args) {
        int num = 1234567890;
        System.out.println(evenAndOddDigitCount(num));
    }

}
