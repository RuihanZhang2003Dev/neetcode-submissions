class Solution {
    public int minPathSum(int[][] grid) {
        /*
        idea: go from end point to the start,and compute the minimum steps and put it in the grid,
        use bfs to find minPath
        */
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] minPath = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            Arrays.fill(minPath[row], Integer.MAX_VALUE);
        }

        minPath[rows-1][cols -1] = grid[rows-1][cols-1];
        for (int row = rows -1; row >= 0; row--) {
            for (int col = cols -1; col >= 0; col--) {
                if (col +1 < cols) {
                    int newPath= grid[row][col] +minPath[row][col+1];
                    minPath[row][col] = Math.min(minPath[row][col], newPath);
                }
                if (row +1 < rows) {
                    int newPath= grid[row][col] +minPath[row+1][col];
                    minPath[row][col] = Math.min(minPath[row][col], newPath);
                }
            }
        }
        return minPath[0][0];
        
        
    }
}