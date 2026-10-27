public class SquareNatSum {
    public static void main(String[] args) {
              int sum = 0;

        for(int i=0;i<10;i++){
            int currentNum = i*i;
            sum+=currentNum;
        }

        System.out.println(sum);
    }
}
