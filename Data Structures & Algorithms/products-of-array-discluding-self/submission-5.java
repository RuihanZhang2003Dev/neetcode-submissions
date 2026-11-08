class Solution {
    public int[] productExceptSelf(int[] nums) {
        /*
        idea: use prefix and suffix: prefix is the product of all elements before the current element
        suffix is the product of all elements after the current element. and the product of array 
        except self would be prefix * suffix
        */
        int len = nums.length;
        int[] pre = new int[len];
        pre[0] = 1;
        int[] suf = new int[len];
        suf[len -1] = 1;

        // fill pre and suf
        int curPre= 1;
        for (int i = 1; i < pre.length; i++) {
            curPre = curPre * nums[i -1];
            pre[i] = curPre;
        } 
        int curSuf =1;
        for (int i = len -2; i >= 0; i--) {
            curSuf = curSuf * nums[i + 1];
            suf[i] = curSuf;
        } 

        int[] result = new int[len];
        for (int i= 0; i< result.length; i++) {
            result[i] = pre[i] * suf[i];
        }
        return result;
    }
}  
