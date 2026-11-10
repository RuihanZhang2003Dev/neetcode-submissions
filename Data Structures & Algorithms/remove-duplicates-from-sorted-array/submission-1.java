class Solution {
    public int removeDuplicates(int[] nums) {
        /*
        idea: use 2 pointers, at each new element, start a right element and remove all duplicates
        in place, after removing all dups, right pointer will point to the next unique num, put that
        num in left, and remove dups, do it until right pointer reaches the end
        */
        int len = nums.length;
        int left = 0;
        int right = 0;

        while (right < len) {
            nums[left] = nums[right];
            
            // remove all dup and move right to the next unique element
            while (right < len && nums[right] == nums[left]) {
                right++;
            }
            left++;
            
        }
        return left;
    }
}