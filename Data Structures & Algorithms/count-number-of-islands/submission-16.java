class Solution {
    public int numIslands(char[][] grid) {
        /*
        idea: find the first island, expand until there is no more island, mark them all as 0 and go find
        the next island again
        */
        int num = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1') {
                    num++;
                    grid[row][col] = '0'; 
                    Queue<int[]> coords = new LinkedList<>();
                    coords.offer(new int[]{row, col});
                    
                    while (!coords.isEmpty()) {
                        int[] cur = coords.poll();
                        int r = cur[0];
                        int c = cur[1];
                        // explore 4 directions
                        if (r -1 >= 0 && grid[r -1][c] == '1') {
                            grid[r-1][c] = '0';   // mark as visited
                            coords.offer(new int[]{r-1, c});
                        }
                        if (c -1 >= 0 && grid[r][c-1] == '1') {
                            grid[r][c-1] = '0';   // mark as visited
                            coords.offer(new int[]{r, c-1});
                        }
                        if (r +1 < rows && grid[r +1][c] == '1') {
                            grid[r+1][c] = '0';   // mark as visited
                            coords.offer(new int[]{r+1, c});
                        }
                        if (c+1 < cols && grid[r][c+1] == '1') {
                            grid[r][c+1] = '0';   // mark as visited
                            coords.offer(new int[]{r, c+1});
                        }
                    }
                }
            }
        }
        return num;
        
    }
}
