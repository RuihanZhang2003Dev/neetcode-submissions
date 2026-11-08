class Solution {
    public int[] productExceptSelf(int[] nums) {
        /*
        idea: use prefix and suffix: prefix is the product of all elements before the current element
        suffix is the product of all elements after the current element. and the product of array 
        except self would be prefix * suffix, we can do pre and suf on the result array immediately
        */
        int len = nums.length;
        int[] result = new int[len];
        result[0] =1;
        result[len -1] = 1;

        // fill pre and suf
        int curPre= 1;
        for (int i = 1; i < len; i++) {
            curPre = curPre * nums[i -1];
            result[i] = curPre;
        } 
        int curSuf =1;
        for (int i = len -2; i >= 0; i--) {
            curSuf = curSuf * nums[i + 1];
            result[i] *= curSuf;
        } 

        return result;
    }
}  
