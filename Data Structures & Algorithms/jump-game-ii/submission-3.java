class Solution {
    public int jump(int[] nums) {
        /*
        idea: here we need to know the minimum steps to reach the end of the array from the 
        beginning. So we check from range to range, at this number, we get the furthest place
        reachable from here. check if we have already included that position in the next
        range we are going to iterate through. if it is not included, include that position
        in to the range by updating the right pointer. if it is, do nothing. At the end of the
        iteration through current range, we will update the current left to 
        */

        int len = nums.length;
        int left = 0;
        int right = 0;
        int step = 0;


        while (right < len -1) {
            step++; // increase step count before all since we are now taking this step,
            // if we found that we can reach the end of the array within this step, return
            // current step
            int newRight = right + 1;
            while (left <= right) {
                int curStep = nums[left];
                // if the new right is smaller than the furthest reachable position of the 
                // current left, update the range
                if (newRight < left + curStep) newRight = left + curStep;
                if (newRight >= len -1) return step;
                left++;
            }
            right = newRight;
        }
        return step;
    }
}
