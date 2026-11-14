class Solution {
    public int islandPerimeter(int[][] grid) {
        // idea: increase sum by 4 when we find an island square and decrease by 1 each time we check its 
        // neighbor and it turns out to be an island
        int sum = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) {
                    sum += 4;
                    if (row -1 >= 0 && grid[row -1][col] == 1) sum--;
                    if (col -1 >= 0 && grid[row][col -1] == 1) sum--;
                    if (row +1 < rows && grid[row +1][col] == 1) sum--;
                    if (col +1 < cols && grid[row][col +1] == 1) sum--;
                }
            }
        }
        return sum;
    }
}