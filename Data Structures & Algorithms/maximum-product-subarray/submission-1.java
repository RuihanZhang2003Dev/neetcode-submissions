class Solution {
    public int maxProduct(int[] nums) {
        /*
        idea: keep track of the current maximum and the current minimum so that the next time we 
        encounter a negative number, we can multiply both max and min to that number to get the
        maximum and new minimum, the new minumum can be itself
        */

        int max = Integer.MIN_VALUE;
        int curMax = 1;
        int curMin = 1;

        for (int n: nums) {
            int tmpMax = curMax * n;
            int tmpMin = curMin * n;
            curMax = Math.max(Math.max(tmpMin, tmpMax), n); 
            // tmpMin can * a negative number and become positive and same goes with tmpMax
            curMin = Math.min(Math.min(tmpMin, tmpMax), n);
            max = Math.max(max, curMax);
        }
        return max;
    }
}
