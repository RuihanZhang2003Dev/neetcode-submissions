class Solution {
    public int maxProfit(int[] prices) {
        /*
        idea: use bottom up dp, interate from the back to front, check what is the maximum profit 
        from that day, we have 2 options: not buy - checks the maxprofit of next day, buy, check
        if it helps the maxprofit of next day. 
        */

        int[] curMax = new int[prices.length];
        for (int i = prices.length -2; i>= 0; i--) {
            // i+1 is not buy and check for the maxprofit of next day
            // or buy and sell combine the next day combine with the max profit, get the max of that
            curMax[i] = Math.max(curMax[i+1], prices[i + 1] - prices[i] + curMax[i+1]);
        }
        return curMax[0];
    }
}