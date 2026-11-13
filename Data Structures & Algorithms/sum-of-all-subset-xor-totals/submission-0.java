class Solution {
    public int subsetXORSum(int[] nums) {
        return dfs(nums, 0, 0);
    }

    private int dfs(int[] nums, int ind, int total){
        if (ind == nums.length) return total;

        // 2 choices: include nums[i], or not include it
        return dfs(nums, ind + 1, total ^ nums[ind]) + dfs(nums, ind + 1, total);
    }
}