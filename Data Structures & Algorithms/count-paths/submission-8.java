class Solution {
    public int uniquePaths(int m, int n) {
        /*
        idea: use bottom up dp, the base case would be there is 1 way to reach the end and we 
        propagate the 2d grid from there
        maybe not 2d grid, maybe to optimize space, use row per row
        */
        int[] curRow = new int[n];
        Arrays.fill(curRow, 1);

        for (int row = 0; row< m-1; row++) {
            /*
            int[] newRow = new int[n];
            newRow[n-1] = 1;
            */
            for (int col = n-2; col>= 0; col--) {
                curRow[col] = curRow[col] + curRow[col+1];
            }
            //curRow = newRow;
        }
        return curRow[0];
    }
}
