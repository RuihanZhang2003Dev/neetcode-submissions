class Solution {
    public int minCostClimbingStairs(int[] cost) {
        /*
        idea: use bottom up dp and find the minimum cost to reach the end
        */
        int len = cost.length;
        int[] memo = new int[len +1];
        // base case
        memo[0] = cost[0];
        memo[1] = cost[1];
        for (int i = 2; i< len; i++) {
            memo[i] = cost[i] + Math.min(memo[i-1], memo[i-2]);
        } 
        return Math.min(memo[len -1], memo[len-2]);
    }
}
