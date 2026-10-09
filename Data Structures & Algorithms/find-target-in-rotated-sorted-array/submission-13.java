class Solution {
    public int search(int[] nums, int target) {
        /*
        idea: use binary search, compare ends with target, then update left and right
        */

        int left= 0;
        int right = nums.length -1;

        while (left <= right) {
            int mid = (left+ right) /2;
            // if mid is larger than target, it should be left side, but if the array is rotated, then we
            // also have to check right, if the right most one is still larger than the target, then 
            // it is in the right half, other wise is in the left half
            if (nums[mid] > target) {
                if (nums[right] >= target && nums[right] < nums[mid]) left = mid+1;
                else right = mid-1;
            }

            // if mid is smaller, has to be on right side, since on its left are the numbers smaller
            // than mid
            else if (nums[mid] < target){
                if (nums[right] < nums[mid] || (target <= nums[right] && nums[mid] < nums[right])) {
                    left = mid+1;
                }
                else right = mid-1;
            }
            else return mid;

        }
        return -1;
    }
}
