class Solution {
    public int searchInsert(int[] nums, int target) {
        return helper(nums, target, 0, nums.length);
    }
    public static int helper(int[] nums, int target, int left, int right){
        if (left == right) return left;
        int middle = (left + right)/2;
        if (target > nums[middle]) return helper(nums, target, middle+1, right);
        if (target < nums[middle]) return helper(nums, target, left, middle);
        return middle;
    }
}