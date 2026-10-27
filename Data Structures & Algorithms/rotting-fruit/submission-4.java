class Solution {
    int fresh = 0;
    public int orangesRotting(int[][] grid) {
        /*
        idea: this is also a multi source bfs: find rotten food, explore arround to see if 
        there are fresh ones, if there is, rot it, and move onto that rotten food. if 
        at the end there are still fresh fruits, return -1
        */
        Queue<int[]> coords = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) fresh++;
                if (grid[row][col] == 2) coords.add(new int[]{row, col});
            }
        }
        
        int time = rot(grid, coords);
        if (fresh > 0) return -1;
        return time;
    }

    // helper for rot
    private int rot(int[][] grid, Queue<int[]> coords) {
        int time = 0;
        while (!coords.isEmpty() && fresh > 0) {
            // rot and increase time when there are fresh fruites left
            int size = coords.size();
            for (int i = 0; i< size; i++) {
                int[] coord = coords.poll();
                int row = coord[0];
                int col = coord[1];

                if (row +1 < grid.length && grid[row+1][col] == 1) {
                    grid[row+1][col] = 2;
                    fresh--;
                    coords.add(new int[]{row+1, col});
                }
                if (row -1 > -1 && grid[row-1][col] == 1) {
                    grid[row-1][col] = 2;
                    fresh--;
                    coords.add(new int[]{row-1, col});
                }
                if (col +1 < grid[0].length && grid[row][col+1] == 1) {
                    grid[row][col+1] = 2;
                    fresh--;
                    coords.add(new int[]{row, col+1});
                }
                if (col -1 > -1 && grid[row][col-1] == 1) {
                    grid[row][col-1] = 2;
                    fresh--;
                    coords.add(new int[]{row, col-1});
                }
            }
            time++; 
            
        }
        return time;
    }
}







