class Solution {
    public int maxSubArray(int[] nums) {
        /*
        idea: since we want the max subarray, if the current sum of the left subarray is not 
        even positive, there is no need to keep it, since it will not positively contribute 
        to the sum, so we just discard it. until we find a positive number where we can start
        our sub array from, since now the element itself can contribute to the sub array
        */
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;
        for (int n : nums) {
            curSum += n;
            maxSum = Math.max(maxSum, curSum);
            // if the by adding the current number, the current sum becomes negative, that 
            // means the current sub array will not contribute to the max subarray, discard 
            if (curSum < 0) {
                curSum = 0; 
            }
        }
        return maxSum;

    }
}
