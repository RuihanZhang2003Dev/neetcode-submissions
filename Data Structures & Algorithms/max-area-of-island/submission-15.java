class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        // idea: when encountered with an island, find the area, mark them as visited and move on
        int rows = grid.length;
        int cols = grid[0].length;

        int maxArea = 0;
        for (int row = 0; row <rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) {
                    int area = getArea(grid, row, col);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    // private helper
    private int getArea(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0) {
            return 0;
        }
        
        grid[row][col] = 0;
        int area = 1+ getArea(grid, row+1, col) 
        + getArea(grid, row, col+1) 
        + getArea(grid, row-1, col)  
        + getArea(grid, row, col-1); 
        return area;
    }
}
