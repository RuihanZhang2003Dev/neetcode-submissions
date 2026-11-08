class Solution {
    public int[] productExceptSelf(int[] nums) {
        /*
        idea: use prefix and suffix on the result, prefix first, prefix is the product of all 
        elements before the current element, and then suffix, which is the product of all elements
        after the current element
        */
        int len = nums.length;
        int[] result = new int[len];
        result[0] = 1;
        result[len -1] =1;

        // get prefix
        int pre = 1;
        for (int i = 1; i< len; i++) {
            pre *= nums[i-1];
            result[i] = pre; 
        }
        // get suffix
        int suf = 1;
        for (int i = len -2; i >= 0; i--) {
            suf *= nums[i+1];
            result[i] *= suf;
        }
        return result;
    }
    
}  
