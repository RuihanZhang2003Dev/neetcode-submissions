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
            // include mid when we take left part since it is part of the increasing sequence, but
            // we do not know if it is the beginning of that or not. exclude mid when we take right
            // since we know that somewhere on the right of mid has the smallest number and mid cannot
            // be the smallest number since mid is alredy larger than the right end.
            if (nums[mid] > nums[right]) left = mid+ 1;
            else right = mid;
        }
        return nums[left];
    }
}
