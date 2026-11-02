class Solution {
    public int maxProfit(int[] prices) {
        /*
        idea: you have 3 options: buy, sell, cooldown. everyday we check
        calculate the profit. bottom up
        */
        int n = prices.length;
        int[][] dp = new int[n + 1][2]; 
        // 2 for considering buying and selling

        for (int i = n -1 ; i>= 0; i--) {
            for (int buying = 1; buying >= 0; buying--) {
                // buy 
                if (buying == 1) {
                    // result on holding
                    int buy = dp[i+1][0] - prices[i];   
                    int cool = dp[i+1][1];  // result on not holding
                    dp[i][1] = Math.max(buy, cool);
                }
                // sell
                else {
                    int sell = (i + 2< n)? dp[i+2][1] + prices[i] : prices[i];
                    int cool = dp[i+1][0];
                    dp[i][0] = Math.max(sell, cool);
                }
            }
        }
        return dp[0][1];
    }
}
