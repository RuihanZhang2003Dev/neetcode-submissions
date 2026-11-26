class Solution {
    public int maxProfit(int[] prices) {
        /*
        idea: everyday you can buy or sell. if we can buy (so we not holding), then we can either buy 
        or cooldown if we can sell (so holding), then we can either sell and look for max profit 2 
        days later + current profit or not 
        */

        int len = prices.length;
        // 0 for holding (can sell) and 1 for not holding (can buy)
        int[][] maxProf = new int[len+1][2];   

        for (int i = len -1; i >= 0; i--) {
            for (int j =0; j < 2; j++) {
                if (j == 1) {
                    int buy = maxProf[i+1][0] - prices[i];
                    int cool = maxProf[i+1][1];
                    maxProf[i][j] = Math.max(buy, cool);
                }
                if (j == 0) {
                    int sell = 0;
                    if (i+2 >len) sell = prices[i];
                    else sell = maxProf[i+2][1] + prices[i];
                    int cool = maxProf[i+1][0];
                    maxProf[i][j] = Math.max(sell, cool);
                }
            }
        }
        return maxProf[0][1];
    }
}
