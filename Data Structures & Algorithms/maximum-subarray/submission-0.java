class Solution {
    public int maxSubArray(int[] nums) {
        /*
        idea: use greedy approach, get the index where the biggest element is, and calculate
        the subarray with the maximum sum, from left and right
        */

        List<Integer> maxes = new ArrayList<>();
        maxes.add(0);
        for (int i = 0; i< nums.length; i++) {
            if (nums[maxes.get(0)] < nums[i]) {
                maxes = new ArrayList<>();
                maxes.add(i);
            }
            else if (nums[maxes.get(0)] == nums[i]) {
                maxes.add(i);
            }
        }

        int maxSum = Integer.MIN_VALUE;
        for (int index : maxes) {  
            // iterate through left and right
            int leftMax = 0;
            int leftCur = 0;
            // get the maxSubarray on left of the max element
            for (int i = index -1; i >= 0; i--) {
                leftCur += nums[i];
                if (leftCur > leftMax) leftMax = leftCur;
            }
            // iterate through right
            int rightMax = 0;
            int rightCur = 0;
            // get the maxSubarray on right of the max element
            for (int i = index +1; i < nums.length; i++) {
                rightCur += nums[i];
                if (rightCur > rightMax) rightMax = rightCur;
            }
            // to get the max result starting from current index, you can either:
            // choose left part or right part or choose both.
            int curMax = nums[index] + 
            Math.max(leftMax + rightMax, Math.max(leftMax, rightMax));
            maxSum = Math.max(maxSum, curMax);
        }
        return maxSum;
    }
}
