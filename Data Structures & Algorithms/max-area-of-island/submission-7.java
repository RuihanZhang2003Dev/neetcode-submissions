class Solution {
    int maxArea = 0;
    
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
                    int curArea = getArea(grid, row, col); 
                    maxArea = Math.max(maxArea, curArea);
                }
            }
        }
        return maxArea;
    }

    // helper to get the maxArea, dfs
    private int getArea(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || 
        grid[row][col] == 0) {
            return 0;
        }
        // mark current as visited, then move onto the next one
        grid[row][col] = 0;
        int result = 1;

        result += getArea(grid, row+1, col)+ 
        getArea(grid, row-1, col)+
        getArea(grid, row, col+1)+
        getArea(grid, row, col-1);

        return result;

    }
}
