class Solution {
    public int coinChange(int[] coins, int amount) {
        /*
        idea: use bottom up dp, find the coins needed for 0 to the amount, if we cannot find it
        then return -1
        */

        int[] memo = new int[amount+ 1];

        Arrays.fill(memo, amount +1); // initial fill, amount +1 is an impossible value for coins

        memo[0] = 0; // base case

        for (int coin: coins) {
            if (coin <= amount) memo[coin] =1;  // with coins of exact value, we only need 1
        }

        for (int target = 1; target < memo.length; target++) {
            int minCoin = amount +1;
            for (int coin: coins) {
                if (coin <= target) minCoin = Math.min(minCoin, 1+ memo[target - coin]);   
                // 1+ since we now include this coin
            }
            memo[target] = minCoin;
        }

        if (memo[amount] > amount) return -1;   // impossible value, signifying not found
        return memo[amount];
    }
}
