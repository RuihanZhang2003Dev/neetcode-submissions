class Solution {
    public int minimumEffortPath(int[][] heights) {
        /*
        idea: we should use dijkstra, where we get to go down or right (does not make sense to go left 
        or up from the beginning point), we would use a priority queue, record the shortest variation
        of heights at each square, it is either the one that was recorded before or the current height
        variation + (height variation to reach next square)
        */

        int rows = heights.length;
        int cols = heights[0].length;
        // minimum height variation to reach current square, since we are not requiring a route, we do
        // not need to record the previous path
        int[][] minVar = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            Arrays.fill(minVar[row], Integer.MAX_VALUE);
        }
        minVar[0][0] = 0;
        PriorityQueue<int[]> edges = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        edges.offer(new int[]{0, 0, 0});
        while (!edges.isEmpty()) {
            int[] cur = edges.poll();
            int curEffort = cur[0];
            int row = cur[1];
            int col = cur[2];
            // check if we can go right or down to get a smaller height variation
            // if we can go right, check right
            if (col + 1 < cols) {
                int effort = Math.max(Math.abs(heights[row][col+1]- heights[row][col]), curEffort);
                if (effort < minVar[row][col+1]) {
                    minVar[row][col+1] = effort;
                    edges.offer(new int[]{effort, row, col+1});
                }
            }
            if (col - 1 >= 0) {
                int effort = Math.max(Math.abs(heights[row][col-1]- heights[row][col]), curEffort);
                if (effort < minVar[row][col-1]) {
                    minVar[row][col-1] = effort;
                    edges.offer(new int[]{effort, row, col-1});
                }
            }
            if (row+ 1 < rows) {
                int effort = Math.max(Math.abs(heights[row+1][col]- heights[row][col]), curEffort);
                if (effort < minVar[row+1][col]) {
                    minVar[row+1][col] = effort;
                    edges.offer(new int[]{effort, row+1, col});
                }
            }
            if (row- 1 >= 0) {
                int effort = Math.max(Math.abs(heights[row-1][col]- heights[row][col]), curEffort);
                if (effort < minVar[row-1][col]) {
                    minVar[row-1][col] = effort;
                    edges.offer(new int[]{effort, row-1, col});
                }
            }
        }
        return minVar[rows-1][cols-1];
    }
}






