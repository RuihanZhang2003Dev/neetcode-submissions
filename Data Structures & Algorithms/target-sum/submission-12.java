class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        /*
        idea: since we can go negative then go positive, we need to get the absolute sum and use that
        to get the length of the dp array. iterate through nums and at each time, increase the + and - 
        current num recurrence with the non zero way positions and
        */
        int absSum = 0;
        for (int n: nums) absSum += Math.abs(n);
        if (absSum < Math.abs(target)) return 0;

        int[] curRow = new int[absSum *2+1];
        int zeroPos = absSum;
        curRow[zeroPos] =1; // base case: there is 1 way to achieve sum of 0
        for (int n: nums) {
            int[] newRow = new int[absSum * 2 +1];
            for (int i = 0; i < curRow.length; i++) {
                if (curRow[i] != 0) {
                    newRow[i+ n] += curRow[i];
                    newRow[i- n] += curRow[i];
                }
            }
            curRow = newRow;
        }
        return curRow[zeroPos+ target];
    }
}
