import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class IndianCoins {
    public static void main(String[] args) {
        Integer coins[] = { 1, 2, 5, 20, 50, 100, 200, 500, 1000, 2000 };
        Arrays.sort(coins, Comparator.reverseOrder());
        int amount = 591;
        int coinCount = 0;

        ArrayList<Integer> selectedCoins = new ArrayList<>();
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amount) {

                while (coins[i]<=amount) {
                    coinCount++;
                    selectedCoins.add(coins[i]);
                    amount -=coins[i];
                }
            }
        }
        System.out.println(coinCount);
        System.out.println(selectedCoins);

    }
}
