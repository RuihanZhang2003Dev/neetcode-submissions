class Solution {
    public int rob(int[] nums) {
        /*
        idea: if we start by end, we end at 1, if we start by end -1, we can end by 0, bottom up
        dp, 2 iteration
        */
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int len = nums.length;

        return Math.max(robRange(nums, 1, len -1), robRange(nums, 0, len -2));
    }

    private int robRange(int[] nums, int start, int end) {
        int len = nums.length;
        int[] profits = new int[len+1];
        profits[end] = nums[end];
        for (int i = end-1; i>= start; i--) {
            profits[i] = Math.max(profits[i+1], profits[i+2] + nums[i]);
        }
        return profits[start];
    }
}
