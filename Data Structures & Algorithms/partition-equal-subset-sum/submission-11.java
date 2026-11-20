class Solution {
    public boolean canPartition(int[] nums) {
        /*
        idea: compute the sum of the nums, if the sum is divisible by 2, then proceed, if not ,return
        false. when we proceed, we sort the nums and go from back to front to use the larger number 
        first, use bottom up dp to store past computations
        */
        int sum = 0;
        for (int n: nums) sum += n;
        if (sum % 2 == 1) return false;
        Arrays.sort(nums);
        int target = sum/2;
        
        boolean[] canReach = new boolean[target+1];
        canReach[0] = true;
        for (int i = nums.length-1; i>= 0; i--) {
            int cur = nums[i];
            if (cur > target) return false;
            else if (cur == target) return true;
            else {
                for (int s = target; s >= cur; s--) {
                    if (canReach[s - cur]) canReach[s] = true;
                }
            }
            
        }
        return canReach[target];
    }
}
