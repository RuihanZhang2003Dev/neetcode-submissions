class Solution {
    public int search(int[] nums, int target) {
        return helper(nums, target, 0, nums.length-1);
        
    }
    public static int helper(int[] nums, int target, int left, int right){
        /*
        idea: find the middle one, if the middle element < target, that means target has to be
        in the right section, otherwise it is in the left section 
        */ 
        if (left == right && nums[left] != target) return -1;
        int middle = (left+ right)/2;
        if (nums[middle] == target) return middle;
        if (target > nums[middle]) return helper(nums, target, middle + 1, right);
        return helper(nums, target, left, middle);
    }
}
