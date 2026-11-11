class Solution {
    public int findDuplicate(int[] nums) {
        // idea: since nums only contains 1 to n, we can use the value itself as index, and when we
        // visited an unvisited node, we mark it as visited by timing it to negative, if it was
        // already visited, then return the number
        for (int i = 0; i< nums.length; i++) {
            int ind = Math.abs(nums[i]) -1;
            if (nums[ind] < 0) return Math.abs(nums[i]);
            nums[ind] *= -1;
        }
        return -1;
    }
}
