class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        /*
        idea: this is similar to the unique path 1, just with obstacles
        */
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        if (obstacleGrid[rows-1][cols-1] == 1) return 0;

        int[] curRow = new int[cols];
        curRow[cols -1] = 1;
        for (int col = cols -2; col>= 0; col--) {
            if (obstacleGrid[rows-1][col] == 1) curRow[col] =0;
            else curRow[col] = curRow[col+1];
        }

        // make new rows
        for (int row = rows-2; row >= 0; row--) {
            int[] newRow = new int[cols];
            for (int col = cols-1; col >= 0; col--) {
                if (obstacleGrid[row][col] == 0) {
                    if (col == cols -1) newRow[col] = curRow[col];
                    else newRow[col] = newRow[col+1] + curRow[col];
                }
            }
            curRow = newRow;
        }
        return curRow[0];
    }
}