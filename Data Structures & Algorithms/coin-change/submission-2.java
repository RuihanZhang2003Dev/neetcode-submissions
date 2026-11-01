class Solution {
    public int coinChange(int[] coins, int amount) {
        /*
        idea: record the minimum amount of coins needed for each amount as memoization, base case
        would be the value of the coin provided (so at those values, we assign the number of coins
        as 1)
        */

        int[] memo = new int[amount + 1];
        
        for (int i = 0; i < memo.length; i++) {
            memo[i] = amount + 1;   // initialize them to amount + 1, impossible
        }

        memo[0] = 0;
        for (int i = 0; i< coins.length; i++) {
            if (coins[i] > amount) continue;    // if coins have larger value than current amount
            memo[coins[i]] = 1;
        }

        for (int target = 1; target < memo.length; target++) {
            if (memo[target] == 1) continue;
            int minCoin = amount + 1;
            for (int coin: coins) {
                if (target >= coin) minCoin = Math.min(minCoin, 1+ memo[target - coin]);
            }

            memo[target] = minCoin;
        }
        if (memo[amount] > amount) return -1;
        return memo[amount];
    }

}
