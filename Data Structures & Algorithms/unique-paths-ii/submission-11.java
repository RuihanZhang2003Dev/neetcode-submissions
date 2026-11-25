class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        /*
        idea: this is similar to the unique path 1, just with obstacles
        */
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        if (obstacleGrid[rows-1][cols-1] == 1 || obstacleGrid[0][0] == 1) return 0;

        int[] curRow = new int[cols];
        curRow[cols -1] = 1;
        // make new rows
        for (int row = rows-1; row >= 0; row--) {
            for (int col = cols-1; col >= 0; col--) {
                if (obstacleGrid[row][col] == 0) {
                    if (col +1 < cols) curRow[col] = curRow[col+1] + curRow[col];
                }
                else curRow[col] = 0;
            }
            
        }
        return curRow[0];
    }
}