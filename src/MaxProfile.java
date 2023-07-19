package src;

public class MaxProfile {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int result = 0;
        for (int price : prices) {
            minPrice = Math.min(price, minPrice);
            result = Math.max(price - minPrice, result);
        }

        return result;
    }
}
