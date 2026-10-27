class Solution {
    public void islandsAndTreasure(int[][] grid) {
        /*
        idea: find all treasures, put it in a queue, spread one step at a time, when we reach 
        a square from a treasure, we can assure that is the nearest one, no need to double check
        since we start spreading from the treasure square and that the current island square is
        not reached at the same time.
        */

        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> coords = new LinkedList<>();
        for (int row = 0; row< rows; row++){
            for (int col = 0; col< cols; col++) {
                if (grid[row][col] == 0) {
                    coords.add(new int[]{row,col});
                }
            }
        }
        
        getDistance(grid, coords);
        
    }

    // helper to replace the square
    private void getDistance(int[][] grid, Queue<int[]> coords) {

        int curDistance = 0;
        
        while (!coords.isEmpty()) {
            int size  = coords.size();
            for (int i = 0; i< size; i++) {
                int[] coord = coords.poll();
                int row = coord[0];
                int col = coord[1];
                // then check 4 directions, if the square is unexplored and an island, and
                // it is not currently in the queue, enqueue it
                if (row + 1 < grid.length && grid[row+1][col] == Integer.MAX_VALUE) {
                    // assign the value now, so that we can avoid that we do not enqueu twice
                    grid[row +1][col] = grid[row][col] +1;  
                    coords.add(new int[]{row+1, col});
                }
                if (row - 1 > -1 && grid[row-1][col] == Integer.MAX_VALUE) {
                    grid[row -1][col] = grid[row][col] +1; 
                    coords.add(new int[]{row-1, col});
                }
                if (col + 1 < grid[0].length && grid[row][col+1] == Integer.MAX_VALUE) {
                    grid[row][col+1] = grid[row][col] +1; 
                    coords.add(new int[]{row, col+1});
                }
                if (col -1 > -1 && grid[row][col-1] == Integer.MAX_VALUE) {
                    grid[row][col-1] = grid[row][col] +1; 
                    coords.add(new int[]{row, col-1});
                }


            }
            curDistance++;
            
        }

        

    }
}





