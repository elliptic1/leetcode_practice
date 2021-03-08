package buy_and_sell_stock;

import sun.jvm.hotspot.utilities.Assert;

public class BuyAndSellStock {
    public static void main(String[] args) {
        Solution s = new Solution();

        Assert.that(s.maxProfit(new int[]{7, 1, 5, 3, 6, 4}) == 5, "first failed");
        Assert.that(s.maxProfit(new int[]{17, 10, 9, 8, 6, 4}) == 0, "second failed");
        Assert.that(s.maxProfit(new int[]{1, 2}) == 1, "third failed");
    }
}

class Solution {
    public int maxProfit(int[] prices) {

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                if (prices[i] - minPrice > maxProfit) {
                    maxProfit = prices[i] - minPrice;
                }
            }
        }

        return Math.max(maxProfit, 0);

    }
}