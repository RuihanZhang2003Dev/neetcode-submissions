class Solution {
    public int search(int[] nums, int target) {
        /*
        idea: go to the part we are supposed to go if the part is either sorted or has a drop, if so,
        go there since having a drop means the min or max is in that part, other wise go to the 
        other part 
        */
        int left = 0;
        int right = nums.length-1;

        while (left <= right) {
            int mid = left + (right - left)/2;

            if (nums[mid] == target) return mid;

            // check before going: if the part is ordered or there is a drop
            if (nums[mid] < target) {
                if (nums[right] >= target || nums[mid] > nums[right]) left = mid +1;
                else right = mid -1;
            }
            else {
                if (nums[left] <= target || nums[mid] < nums[left]) right = mid-1;
                else left = mid +1;
            }
        }
        return -1;
    }
}
