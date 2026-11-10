class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        /*
        idea: this is the same question than the longest repeating character, expand the window when
        target is not reached, shrink from left when reached
        */

        int sum = 0;
        int left = 0;
        int minWindow = Integer.MAX_VALUE;
        //expand until target is surpassed, shrink left until sum is smaller than target again
        for (int right = 0; right< nums.length; right++) {
            sum += nums[right];
            while (sum >= target && left <= right){
                minWindow = Math.min(minWindow, right- left +1);
                sum -= nums[left];
                left++;
            }
        }
        if (minWindow == Integer.MAX_VALUE) return 0;
        return minWindow;
    }
}