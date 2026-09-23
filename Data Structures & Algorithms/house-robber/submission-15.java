class Solution {
    public int rob(int[] nums) {
        /*
        idea: you will have 2 choices, either rob or skip, rob means you have to go to 
        skip the next house, skip means you get to rob the house, use memoization to 
        remember the past results
        */
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return helper(0, nums, memo);
    }

    public static int helper(int start, int[] nums, int[] memo) {
        if (start >= nums.length) return 0;
        if (memo[start] != -1) return memo[start];

        // 2 choices from here
        int rob = nums[start] + helper(start+2, nums, memo);

        int skip = helper(start+1, nums, memo);
        return memo[start] = Math.max(rob, skip);
    }
}
