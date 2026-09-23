class Solution {
    public int climbStairs(int n) {
        /*
        idea: use memoization, so store the number of ways for the combination that are alraedy
        computed to avoid recomputing.
        */
        int[] ways = new int[n+1];
        
        return getWays(n, ways);
    }

    public static int getWays(int n, int[] ways){
        if (n <= 2) return n;
        if (ways[n] == 0) {
            ways[n] = getWays(n-1, ways) + getWays(n-2, ways);
        }
        return ways[n];
    }
}
