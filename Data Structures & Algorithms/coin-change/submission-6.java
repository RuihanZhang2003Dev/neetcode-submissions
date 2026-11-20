class Solution {
    public int coinChange(int[] coins, int amount) {
        /*
        idea: having base case of coins values at the amount of counts, use top down dp
        */
        if (amount == 0) return 0;
        int[] targets = new int[amount +1];
        Arrays.fill(targets, Integer.MAX_VALUE);
        targets[0] = 0;
        for (int i = 0; i < amount; i++) {
            if (targets[i] == Integer.MAX_VALUE) continue;
            for (int coin: coins) {
                if (coin <= amount-i) {
                    targets[i + coin] = Math.min(1 + targets[i], targets[i+ coin]);
                }
            }
        }
        if (targets[amount] == Integer.MAX_VALUE) return -1;
        return targets[amount];
    }
}
