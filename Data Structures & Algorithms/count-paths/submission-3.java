class Solution {
    public int uniquePaths(int m, int n) {
        /*
        idea: we can only move down or to the right, so we use bottom up DP on 2d dp: start at the 
        end, since we are at the end, the base case would be 1 unique path since there is only 1 way 
        to reach from the end to the end. then we can move to the left square, at that square, we
        can only move right or down, if by moving, we move out of the graph, that means there is 0
        unique path to the end if we go down that direction. and if by moving to the right we go to
        the end, that means there is only 1 unique path that goes to the end from that square. so
        the formula is # unique path at square x = #unique path at square y on the right of x + 
        # unique path at square z on the bottom of x, that is also why we start from bottom, so that
        in future iterations, when we go down, we got the number of the unique path on the bottom
        of the square,same reason as why we go from right to left
        */

        int rows = m;
        int cols = n;
        int[] row = new int[cols];    // the last row
        Arrays.fill(row, 1);

        for (int r = rows -2; r >= 0; r--) {
            int[] newRow = new int[cols];
            Arrays.fill(newRow, 1);
            for (int col = cols -2; col >= 0; col--) {  // col -2 since the last column is always 1
                // get down and right
                newRow[col] = newRow[col+1] + row[col];
            }
            row = newRow;
        }
        return row[0];
    }
}
