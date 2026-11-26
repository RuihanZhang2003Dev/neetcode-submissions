class Solution {
    public int minPathSum(int[][] grid) {
        /*
        idea: go from end point to the start,and compute the minimum steps and put it in the grid,
        check right and down to see which one is the better option, bottom up dp
        to optimize space, use 2 rows
        */
        int rows = grid.length;
        int cols = grid[0].length;

        int[] minPath = new int[cols];
        minPath[cols -1] = grid[rows-1][cols-1];

        for (int row = rows -1; row >= 0; row--) {
            for (int col = cols -1; col >= 0; col--) {
                if (row == rows- 1 && col == cols -1) continue;
                int goRight = Integer.MAX_VALUE;
                int goDown = Integer.MAX_VALUE;
                if (col +1 < cols) goRight = grid[row][col] +minPath[col+1];
                if (row +1 < rows) goDown = grid[row][col] +minPath[col];
                minPath[col] = Math.min(goRight, goDown);
            }
        }
        return minPath[0];
        
        
    }
}