class Solution {
    public int search(int[] nums, int target) {
        /*
        idea: check which part is sorted and if in the zone the target is suppose to go to has a drop
        since if that zone has a drop, we are garanteed that the max and min are in that zone
        */

        int left= 0;
        int right = nums.length -1;

        while (left <= right) {
            int mid = left + (right - left)/2;

            if (nums[mid] == target) return mid;

            // go right if right side is sorted or right side has the drop
            if (nums[mid] < target) {
                if (nums[right] >= target || nums[mid] > nums[right]) left = mid+1;
                else right = mid -1;
            }
            // go left if left is sorted or left has a drop
            else {
                if (nums[left] <= target || nums[left] > nums[mid]) right = mid -1;
                else left = mid +1;
            }
        }
        return -1;
    }
}
