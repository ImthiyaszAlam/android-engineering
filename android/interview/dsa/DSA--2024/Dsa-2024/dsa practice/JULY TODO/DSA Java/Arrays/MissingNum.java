public class MissingNum {
    public static void main(String[] args) {
        int a[] = { 3, 5,4,2 };
        int n = a.length+1;
        int sum = (n * (n + 1)) / 2; //   
        for (int i = 0; i < a.length; i++) {
            sum = sum - a[i];   // 3+4
        }
        System.out.println("missing number is: "+sum);

    }
}
