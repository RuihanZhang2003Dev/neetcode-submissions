class Solution {
    public void islandsAndTreasure(int[][] grid) {
        /*
        idea: find treasure, and then perform multisource bfs step by step and assign distances to
        islands surrounding them. the distance is garanteed to be minimal since it the propagation
        speed is the same and whoever reached that island first will have its distance on it first.
        */
        Queue<int[]> coords = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 0) coords.offer(new int[]{row, col});
            }
        }

        int dist = 1;
        while (!coords.isEmpty()) {
            // to propagate step by step, we will only poll the coords we have stored in the past
            // iteration, all coords offered in this iteration will be iterated through in the 
            // next iteration
            int size = coords.size();
            for (int i =0 ; i< size; i++) {
                int[] coord = coords.poll();
                int row = coord[0];
                int col = coord[1];

                // explore 4 directions for viable islands
                if (row-1 >=0 && grid[row -1][col] == Integer.MAX_VALUE) {
                    grid[row-1][col] = dist;
                    coords.offer(new int[]{row -1, col});
                }
                if (col-1 >=0 && grid[row][col-1] == Integer.MAX_VALUE) {
                    grid[row][col-1] = dist;
                    coords.offer(new int[]{row, col-1});
                }
                if (row+1 <rows && grid[row +1][col] == Integer.MAX_VALUE) {
                    grid[row+1][col] = dist;
                    coords.offer(new int[]{row +1, col});
                }
                if (col +1 <cols && grid[row][col+1] == Integer.MAX_VALUE) {
                    grid[row][col+1] = dist;
                    coords.offer(new int[]{row, col+1});
                }
            }
            dist++;
        }
    }
}
