class Solution {
    public boolean canJump(int[] nums) {
        /*
        idea: classic dp bottom up question, start from back to front, where the base case
        is that the last index can reach the last index
        greedy: still bottom up dp, we can just store the last index (closest to current) that
        can reach the end. since we can jump at most nums[i] step. if we can reach the the 
        last index that can reach the end within those steps, then the current index is 
        reachable too.
        */

        int len = nums.length;
        // base case, the first index that is reachable from the end is itself
        int canReach = len -1; 
    
        for (int i = len -2; i>= 0; i--) {
            int maxStep = nums[i];
            // if from current position, we can reach the latest index that can reach the end
            // within maxstep, the current position becomes the latest index that can reach
            // the end.
            if (i + maxStep >= canReach) canReach = i;
        }
        return canReach == 0;
    }
}
