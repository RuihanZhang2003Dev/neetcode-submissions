class Solution {
    public int uniquePaths(int m, int n) {
        /*
        idea: use bottom up dp, the base case would be there is 1 way to reach the end and we 
        propagate the 2d grid from there
        maybe not 2d grid, maybe to optimize space, you can only work on 1 row
        */
        int[] curRow = new int[n];
        Arrays.fill(curRow, 1);

        for (int row = 0; row< m-1; row++) {
            for (int col = n-2; col>= 0; col--) {
                curRow[col] = curRow[col] + curRow[col+1];
            }
        }
        return curRow[0];
    }
}
