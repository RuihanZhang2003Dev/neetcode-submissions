class Solution {
    public int numIslands(char[][] grid) {
        /*
        idea: bfs, go through layer by layer, when visiting a node, we check if it is an island,
        if it is, we check if they got any unvisited island neighbor, if not, find the next
        unvisited island
        */

        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int row = 0; row< rows; row++){
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '2' || grid[row][col] == '0') continue;
                else {
                    count++;
                    visit(grid, row, col);
                }
            }
        }
        return count;
    }

    // helper to get the whole island 
    private void visit(char[][] grid, int row, int col) {
        // what this helper does: mark current one as visited, and if there is a neighbor that 
        // is unvisited and an island, visit there, other wise stop

        grid[row][col] = '2'; // mark visited as 2
        // now check 4 direction, and if any of them is available, then visit
        if (row + 1 < grid.length && grid[row+ 1][col] == '1') {
            visit(grid, row+1, col);
        } 
        if (row - 1 > -1 && grid[row- 1][col] == '1') {
            visit(grid, row-1, col);
        } 
        if (col + 1 < grid[0].length && grid[row][col+1] == '1') {
            visit(grid, row, col+1);
        } 
        if (col-1 > -1 && grid[row][col-1] == '1') {
            visit(grid, row, col-1);
        } 


    }
}
