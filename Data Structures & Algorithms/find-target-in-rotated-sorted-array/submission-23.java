class Solution {
    public int search(int[] nums, int target) {
        /*
        idea: check which half is sorted, and is target is in the sorted half?
        */
        int left = 0;
        int right = nums.length -1;

        while (left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == target) return mid;
            
            // if num < target, supposed to go right
            if (nums[mid] < target) {
                if (nums[right] > nums[mid] && target <= nums[right] ||
                nums[right] < nums[mid]) left = mid+1;
                else right = mid -1;
            }
            else {
                if (nums[left] < nums[mid]  && target >= nums[left] ||
                nums[left] > nums[mid]) right = mid -1;
                else left = mid+1;
            }
        }
        return -1;
    }
}
