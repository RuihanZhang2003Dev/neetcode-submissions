class Solution {
    public int rob(int[] nums) {
        /*
        idea: 2 choices: skip current house and rob the next one or rob this one and skip the next 
        one, bottom up dp
        */
        // base case: start with first or second house
        if (nums.length == 1) return nums[0];
        int len = nums.length;
        int[] profits= new int[len+1];
        profits[len] = 0;
        profits[len -1] = nums[len-1];
        for (int i =len-2; i>= 0; i--) {
            // if we rob the current house, that means we skipped the last house
            // if we do not rob the current house, that means we either robbed last house or not
            profits[i] = Math.max(nums[i] + profits[i +2], profits[i+1]);
        }
        return Math.max(profits[0], profits[1]);
    }
}
