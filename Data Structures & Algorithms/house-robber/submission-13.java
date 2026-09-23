class Solution {
    public int rob(int[] nums) {
        /*
        idea: you will always get 2 choices, you rob the current one, or you can 
        rob the next one, so the starting point is either 0, or 1, and then the next
        starting point will be 2 or 3.
        use a hashmap to store the starting point, max profit pair
        */
        
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return getMaxProfit(0, nums, memo);
    }

    public static int getMaxProfit(int start, int[] nums, int[] memo){
        if (start >= nums.length) return 0;
        if (memo[start] != -1) return memo[start];
        
        // 2 choices
        // choose the current one 
        int profit1 = nums[start] + getMaxProfit(start + 2, nums, memo);

        

        // choose the next one
        int profit2 = getMaxProfit(start + 1, nums, memo);

        return memo[start] = Math.max(profit1, profit2);
    }


}
