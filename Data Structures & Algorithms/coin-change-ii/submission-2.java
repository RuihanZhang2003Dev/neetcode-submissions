class Solution {
    public int change(int amount, int[] coins) {
        /*
        idea: we want combination, so order does not matter, coins on the outside, so each combination 
        gets built in one fixed order, that way 1+2 and 2+1 gets counted once. bottom up dp
        */
        
        int[] combinations = new int[amount+1];
        combinations[amount] =1;

        for (int coin: coins){
            for (int i = amount-1; i >= 0; i--) {
                if (i + coin <= amount) {
                    combinations[i] += combinations[i+coin];
                }
            }
        }
        return combinations[0];
    }
}
