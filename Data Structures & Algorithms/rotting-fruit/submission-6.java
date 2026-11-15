class Solution {
    public int orangesRotting(int[][] grid) {
        /*
        idea: multi source bfs, use rotten fruits as source, and propagate, moreover, keep track of
        the fresh food, if at the end of propagation, there are still fresh fruits left, then we 
        return -1
        */

        Queue<int[]> coords = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        int fresh = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) fresh++;
                else if (grid[row][col] == 2){
                    coords.offer(new int[]{row, col});
                }
            }
        }

        int timer = 0;
        while (!coords.isEmpty()) {
            if (fresh == 0) return timer;
            int size = coords.size();
            for (int i =0; i< size; i++) {
                int[] coord = coords.poll();
                int row = coord[0];
                int col = coord[1];

                if (row-1 >= 0 && grid[row -1][col] == 1) {
                    grid[row-1][col] = 2;
                    fresh--;
                    coords.offer(new int[]{row -1, col});
                }
                if (col-1 >= 0 && grid[row][col-1] == 1) {
                    grid[row][col-1] = 2;
                    fresh--;
                    coords.offer(new int[]{row, col-1});
                }
                if (row+1 < rows && grid[row+1][col] == 1) {
                    grid[row+1][col] = 2;
                    fresh--;
                    coords.offer(new int[]{row +1, col});
                }
                if (col +1 < cols && grid[row][col+1] == 1) {
                    grid[row][col+1] = 2;
                    fresh--;
                    coords.offer(new int[]{row, col+1});
                }
            }
            timer++;
        }
        if (fresh > 0) return -1;
        return timer;
    }
}
