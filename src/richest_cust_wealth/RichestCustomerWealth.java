package richest_cust_wealth;

public class RichestCustomerWealth {
}

class Solution {
    public int maximumWealth(int[][] accounts) {
        int max_wealth = 0;
        for (int i = 0; i < accounts.length; i++) {
            int w = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                w += accounts[i][j];
            }
            if (w > max_wealth) {
                max_wealth = w;
            }
        }
        return max_wealth;
    }
}