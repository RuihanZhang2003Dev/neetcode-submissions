class Solution {
    public boolean canJump(int[] nums) {
        /*
        idea: classic dp bottom up question, start from back to front, where the base case
        is that the last index can reach the last index
        */

        int len = nums.length;
        boolean[] canReach = new boolean[len];
        canReach[len -1] = true;

        for (int i = len -2; i>= 0; i--) {
            int maxStep = nums[i];
            boolean reachable = false;
            for (int j = 0; j <= maxStep && i + j < len; j++) {
                reachable = reachable || canReach[i + j];
            }
            canReach[i] = reachable;
        }
        return canReach[0];
    }
}
