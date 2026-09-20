class Solution {
    public int maxProfit(int[] prices) {
        /*
        idea: iterate through the prices and compare, keep the minimum of the past
        so that we can compare profit
        */
        int maxProfit = 0;
        int curMin= prices[0];
        for (int i = 1; i< prices.length; i++){
            curMin = Math.min(prices[i], curMin);
            if (prices[i] > curMin) maxProfit = Math.max(maxProfit, prices[i] - curMin);
        }

        return maxProfit;
    }
}
