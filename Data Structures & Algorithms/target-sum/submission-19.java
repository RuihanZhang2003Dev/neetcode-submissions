class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        /*
        idea: since we can go negative then go positive, we need to get the absolute sum and use that
        to get the length of the dp array. iterate through nums and at each time, increase the + and - 
        current num recurrence with the non zero way positions and
        */
        int absSum = 0;
        for (int n: nums) absSum += Math.abs(n);
        if (Math.abs(target) > absSum || (target + absSum) % 2 != 0) return 0;
        int p = (target + absSum)/2;

        int[] dp = new int[p+1];
        dp[0] = 1;  // base case: 1 way to reach 0
        for (int n: nums) {
            for (int s = p; s >= n; s--) {
                dp[s] += dp[s-n];
            }
        }
        return dp[p];
    }
}
