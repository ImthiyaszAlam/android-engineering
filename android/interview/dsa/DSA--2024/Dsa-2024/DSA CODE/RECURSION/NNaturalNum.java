public class NNaturalNum {

    public static int sumN(int n) {
        if (n == 1) {
            return n;
        }
        int sumn1 = sumN(n - 1);
        int sum = n + sumn1;
        return sum;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(sumN(n));
    }
}
