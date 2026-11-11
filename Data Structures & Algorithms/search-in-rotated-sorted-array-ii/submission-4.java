class Solution {
    public boolean search(int[] nums, int target) {
        /*
        idea: this is the same, just avoid the same elements when we move pointers
        */
        int left = 0;
        int right = nums.length -1;

        while (left <= right) {
            while (right > left && nums[right] == nums[right -1]) right--;
            while (left < right&& nums[left] == nums[left +1]) left++;
            int mid = left + (right - left)/2;
            
            if (nums[mid] == target) return true;

            // go right if it is sorted or there is a drop when the current number is too small
            if (nums[mid] < target) {
                if (nums[right] >= target || nums[right] < nums[mid]) left = mid +1;
                else right = mid -1;
            }
            else {
                if (nums[left] <= target || nums[left] > nums[mid]) right = mid-1;
                else left = mid +1;
            }
        }
        return false;
    }
}