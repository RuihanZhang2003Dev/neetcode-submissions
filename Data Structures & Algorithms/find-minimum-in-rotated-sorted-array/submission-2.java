class Solution {
    public int findMin(int[] nums) {
        /*
        idea: use binary search, compare ends, choose the smaller half
        */
        int left = 0;
        int right = nums.length -1;

        while (left < right) {
            int mid = (left + right) /2;
            // compare mid with right, if mid > right, then it means it is in the right, since it is sorted
            // and if mid < right, then it is in the right half
            if (nums[right] < nums[mid]) left = mid+ 1;
            else right = mid;
        }
        return nums[left];
    }
}
