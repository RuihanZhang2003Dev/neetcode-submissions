class Solution {
    public int maxProfit(int[] prices) {
        /*
        idea: scan left to right, keep track of minimum value at each step
        compare the current price to the min value to get profit, compare with max profit
        */
        int min = Integer.MAX_VALUE;
        int maxProf = 0;    
        for (int i = 0; i< prices.length; i++){
            min = Math.min(min, prices[i]);
            maxProf = Math.max(maxProf, prices[i]- min);
        }

        return maxProf;
    }
}
