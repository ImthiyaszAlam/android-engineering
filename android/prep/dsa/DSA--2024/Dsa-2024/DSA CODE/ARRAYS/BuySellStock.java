public class BuySellStock {

    public static int buyAndSellStock(int stockPrices[]) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < stockPrices.length; i++) {
            if (buyPrice < stockPrices[i]) {
                int profit = stockPrices[i] - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buyPrice = stockPrices[i];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int prices[] = { 7, 1, 5, 3, 6, 4 };
        System.out.println(buyAndSellStock(prices));
    }
}
