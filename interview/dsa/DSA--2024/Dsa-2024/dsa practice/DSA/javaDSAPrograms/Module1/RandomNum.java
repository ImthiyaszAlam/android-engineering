import java.util.Random;

public class RandomNum {
    public static void main(String[] args) {

        Random random = new Random();
        int rNumber = random.nextInt(1000);
        System.out.println("Random Number is:"+rNumber);
        double rDouble = random.nextDouble();
        System.out.println("Random Float is :"+rDouble);
    }
}
