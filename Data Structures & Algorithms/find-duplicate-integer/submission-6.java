class Solution {
    public int findDuplicate(int[] nums) {
        // idea: since nums contains only 1- n, we can use it as index. We will visit the element in
        // the index and mark them as visited by multiplying it to -1. so that the next time we 
        // visit the same place, we know that the current position is visited

        for (int i = 0; i< nums.length; i++) {
            int ind = Math.abs(nums[i]) -1;
            if (nums[ind] < 0) return Math.abs(nums[i]);
            nums[ind] *= -1;
        }
        return -1;  // never reached
    }
}
