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
        int[][] grid = new int[rows][cols];
        grid[rows -1][cols -1] = 1; // base case, end point

        for (int row = rows -1; row >= 0; row--) {
            for (int col = cols -1; col >= 0; col--) {
                if (row == rows -1 && col == cols -1) continue;
                // get down and right
                // if we are at last row, just add unique path from right
                if (row + 1 == rows) grid[row][col] = grid[row][col+1];
                // if we are at last col, just add unique path from down
                else if (col + 1 == cols) grid[row][col] = grid[row+1][col];
                else grid[row][col] = grid[row][col+1] + grid[row+1][col];
            }
        }
        return grid[0][0];
    }
}
