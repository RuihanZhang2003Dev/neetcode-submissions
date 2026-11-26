class Solution {
    public int lastStoneWeightII(int[] stones) {
        /*
        idea: we need to make 2 piles of stone's weight/2 to get the smallest last stone weight 
        possible, so we face 2 choices: either choose the current stone if we can, or skip this
        stone and continue
        */

        int stoneSum = 0;
        for (int weight: stones) stoneSum += weight;

        int len = stones.length;
        int target = stoneSum/2;
        int[][] dp = new int[len+1][target+1];

        for (int i = 1; i<= len; i++) {
            for (int t = 0; t <= target; t++) {
                if (t >= stones[i-1]) {
                    // when we have the capacity, include it or exclude it
                    // exclude is you take the previous result and same capacity
                    // include is you take the rock and take the previous result with reduced capacity
                    dp[i][t] = Math.max(dp[i-1][t], dp[i-1][t- stones[i-1]] + stones[i-1]);
                }
                else dp[i][t] = dp[i-1][t];
            }
        }
        return stoneSum - 2*dp[len][target];
    }
}