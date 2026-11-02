class Solution {
    public int change(int amount, int[] coins) {
        /*
        idea: use an array to store memoization, use bottom up dp, go from back to front, # ways to pay
        at i amount is # ways at i + amount fo coins
        */

        int[] ways= new int[amount +1];
        ways[amount] = 1;   // base case
        for (int coin: coins) {
            for (int i = amount; i >= 0; i--) {
                if (i + coin <= amount) {
                    ways[i] += ways[i + coin];
                }
            }
        }
        return ways[0];
    }
}
