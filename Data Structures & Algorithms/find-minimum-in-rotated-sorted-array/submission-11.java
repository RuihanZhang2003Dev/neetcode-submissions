class Solution {
    public int findMin(int[] nums) {
        /*
        idea: binary search and move always beware of the rotation
        */

        int left = 0;
        int right = nums.length -1;
        while (left < right) {
            int mid = left+ (right -left)/2;

            // look right if: right is smaller mid, that means there is a drop, it is in between it
            if (nums[right] < nums[mid]) left = mid+1;
            // look left if: the mid num is larger than left or right is larger than mid, that means 
            // right is in increasing order
            else right = mid;
        }
        return nums[left];
    }
}
