class Solution {
    public int jump(int[] nums) {
        /*
        idea: here we need to know the minimum steps to reach the end of the array from the 
        beginning. Hence we will do smt similar to inlevel traversal, basically we will check
        the current number, check if we have included those steps in the next iteration, if 
        so then we do not need to update, otherwise we update the range of steps to include 
        them
        */

        int len = nums.length;
        int left = 0;
        int right = 0;
        int step = 0;


        while (right < len -1) {
            step++; // increase step count before all since we are now taking this step,
            // if we found that we can reach the end of the array within this step, return
            // current step
            int newLeft = right +1;
            int newRight = right + 1;
            while (left <= right) {
                int curStep = nums[left];
                // if the new right is smaller than the furthest reachable position of the 
                // current left, update the range
                if (newRight < left + curStep) newRight = left + curStep;
                if (newRight >= len -1) return step;
                left++;
            }
            left = newLeft;
            right = newRight;
        }
        return step;
    }
}
