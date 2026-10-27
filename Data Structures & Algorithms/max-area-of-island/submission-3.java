class Solution {
    int maxArea = 0;
    int curArea = 0;    // use curArea to keep count of the area in the current island
    public int maxAreaOfIsland(int[][] grid) {
        /*
        idea: have a global variable maxArea and compare them after getting the area of each 
        whole island
        */

        int rows = grid.length;
        int cols = grid[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 0) continue;
                else {
                    getArea(grid, row, col); 
                    maxArea = Math.max(maxArea, curArea);
                    curArea = 0;    // reset curarea for the next island
                }
            }
        }
        return maxArea;
    }

    // helper to get the maxArea, bfs
    private void getArea(int[][] grid, int row, int col) {
        // mark current as visited, then move onto the next one
        grid[row][col] = 0;
        curArea++;

        // check 4 directions to see if there are still adjacent island
        if (row + 1 < grid.length && grid[row+1][col] ==  1) {
            getArea(grid, row+1, col);
        }
        if (row - 1 > -1 && grid[row-1][col] ==  1) {
            getArea(grid, row-1, col);
        }
        if (col + 1 < grid[0].length && grid[row][col+1] ==  1) {
            getArea(grid, row, col+1);
        }
        if (col - 1 > -1 && grid[row][col-1] ==  1) {
            getArea(grid, row, col-1);
        }

    }
}
