class Solution {
    public int lastStoneWeightII(int[] stones) {
        /*
        idea: 2d dp, since we want the minimum of the weight, all we needed was to see if we can 
        reach the total weight/2 since if we want the min weight left, we need 2 piles that have 
        the minimum difference, which is total weight/2. 
        */

        int stoneSum = 0;
        int len = stones.length;
        for (int weight: stones) stoneSum += weight;
        int target = stoneSum/2;

        int[][] dp = new int[len+1][target+1];

        for (int i = 1; i<= len; i++) {
            for (int t = 0; t<= target; t++) {
                if (t >= stones[i-1]) {
                    // question: you exclude the target and include it again in the max?
                    dp[i][t] = Math.max(dp[i-1][t], dp[i-1][t- stones[i-1]] + stones[i-1]);
                }
                else {
                    dp[i][t] = dp[i-1][t];
                }
            }
        }

        return stoneSum- 2*dp[len][target];
    }
}