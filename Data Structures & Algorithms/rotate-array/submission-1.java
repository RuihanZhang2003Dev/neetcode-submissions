class Solution {
    public void rotate(int[] nums, int k) {
        /*
        idea: reverse the array and divide the array into 2 sub parts, one of length k and one of 
        length n -k
        */
        int len = nums.length;
        int rotation = k % len;
        // reverse the array
        reverse(nums, 0, len-1);
        // reverse the 2 parts
        reverse(nums, 0, rotation-1);
        reverse(nums, rotation, len -1);
        
    }


    // private function for reversal
    private static void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }
    }
}