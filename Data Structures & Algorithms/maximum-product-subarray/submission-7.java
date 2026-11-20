class Solution {
    public int maxProduct(int[] nums) {
        /*
        idea: keep track of the current minimum and current maximum in the window the maximum
        */
        int max = Integer.MIN_VALUE;
        int curMin = 1;
        int curMax = 1;

        for (int n: nums) {
            // if n positive, add it to curmax and curmin if curmin decreases, and if n negative, 
            // curmax becomes max of curmin* n, curmax*n
            int tmpMax = curMax *n;
            int tmpMin = curMin *n;
            curMax = Math.max(Math.max(tmpMax, tmpMin), n);
            curMin = Math.min(Math.min(tmpMax, tmpMin), n);
            max = Math.max(curMax, max);
        }
        return max;

    }
}
