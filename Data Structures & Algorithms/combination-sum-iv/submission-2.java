class Solution {
    public int combinationSum4(int[] nums, int target) {
        /*
        idea: although it is called combination, it is actually permutation, so we iterate through all
        amounts that has a non zero way, and we add the number of ways to achieve amount + each coin 
        values, no need to worry about overcounting by adding the ways in advance and readding it 
        later since (2, 1) and (1, 2) are not the same, we want to include all possible combination
        it is the reverse of coin change, coin changes wants the combination, so order does not matter
        consequently, (2, 1) and (1, 2) are the same
        */

        if (target == 0) return 1; 
        int[] ways = new int[target+1];
        ways[0] =1;
        for (int i = 0; i< ways.length; i++){
            if (ways[i] == 0) continue;
            for (int num: nums) {
                if (i + num <= target) {
                    ways[i+ num] += ways[i];
                }
            } 
        }
        return ways[target];
    }
}