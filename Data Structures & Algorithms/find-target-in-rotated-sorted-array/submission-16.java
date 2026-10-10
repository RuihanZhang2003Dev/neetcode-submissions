class Solution {
    public int search(int[] nums, int target) {
        /*
        idea: use binary search for the target
        */

        int left = 0;
        int right = nums.length -1;

        while (left <= right) {
            if (left == right && nums[left] != target) return -1;
            int mid = (left + right) /2;
            
            // if mid is larger than the target, check with right
            if (nums[mid] > target) {
                // go right if there is a drop and the drop is larger than target
                if (nums[mid] > nums[right] && nums[right] >= target) left = mid +1;
                else right = mid -1;
            }
            // if mid is smaller than target, check with right 
            else if (nums[mid] < target) {
                // go right if there is a drop (meaing the peak is on the right) 
                // or it is in order and the target is within the order
                if ( nums[mid] > nums[right]|| 
                (nums[mid] < nums[right] && target <= nums[right])) left = mid +1;
                else right = mid -1;
            }
            else return mid;
        }

        return -1;
    }
}
