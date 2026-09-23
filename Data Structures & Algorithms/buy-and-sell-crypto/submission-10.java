class Solution {
    public int maxProfit(int[] prices) {
        /*
        idea: scan left to right, keep track of minimum value at each step
        compare the current price to the min value to get profit, compare with max profit
        */
        int minPrice = prices[0];
        int maxProf = 0;
        for (int i = 1; i< prices.length; i++){
            if (prices[i] < minPrice) minPrice = prices[i];
            else maxProf = Math.max(maxProf, prices[i] - minPrice);
        }
        return maxProf;
    }
}
