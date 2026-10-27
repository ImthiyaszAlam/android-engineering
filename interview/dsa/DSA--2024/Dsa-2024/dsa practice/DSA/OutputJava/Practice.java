public class Practice {
    public static void main(String[] args) {
        int n = 15;

        for(int i=1; i<=n; i++){
            if (i%5 == 0 && i%3 ==0) {
                System.out.println("Fizzbuzz");
            }
            if (i%5 == 0) {
                System.out.println("Bizz");
            }
            if (i%3 == 0) {
                System.out.println("Fizz");
            }
            else{
                System.out.println(i);
            }
        }


        
    }
}
