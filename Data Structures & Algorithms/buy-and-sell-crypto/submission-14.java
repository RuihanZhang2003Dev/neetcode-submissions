class Solution {
    public int maxProfit(int[] prices) {
        /*
        idea: iterate through the array, keep track of the minimum in the past, and compare current
        profit with max profit
        */
        int min = Integer.MAX_VALUE;
        int maxProf = 0;

        for (int price: prices) {
            min = Math.min(price, min);
            maxProf = Math.max(price- min, maxProf); 
        }
        return maxProf;
    }
}
