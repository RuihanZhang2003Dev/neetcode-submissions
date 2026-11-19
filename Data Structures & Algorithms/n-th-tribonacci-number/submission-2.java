class Solution {
    public int tribonacci(int n) {
        /*
        idea: classic bottom up dp, instead of 1 base case we now have 3
        */
        if (n == 0) return 0;
        if (n < 3) return 1;
        int[] memo = new int[n+1];
        memo[0] =0; 
        memo[1] =1;
        memo[2] =1;

        for (int i = 3; i<= n; i++) {
            memo[i] = memo[i-1] + memo[i-2] +memo[i-3];
        }
        return memo[n];
    }
}