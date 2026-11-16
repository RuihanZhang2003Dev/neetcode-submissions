class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        /*
        idea: instead of finding if the square in the grid can reach both ocean, we should find which
        square is reachable from the ocean (so squares having higher heights above the sea). the ones
        beside the seas are all reachable, since there are 2 oceans, we should have 2 method doing
        this and use 2 boolean grids to mark which square is reachable from which ocean
        */
        int rows = heights.length;
        int cols = heights[0].length;
        
        boolean[][] reachPac = new boolean[rows][cols];
        boolean[][] reachAtl = new boolean[rows][cols];
        List<List<Integer>> res = new ArrayList<>();
        
        

        canReachPac(heights, reachPac);
        canReachAtl(heights, reachAtl);

        // find the intersection of both matrices(find the squares that both oceans can reach)
        for (int row= 0; row< rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (reachPac[row][col] && reachAtl[row][col]) {
                    res.add(List.of(row, col));
                }
            }
        }
        return res;
    }

    private static void canReachPac(int[][] heights, boolean[][] reachPac) {
        int rows = heights.length;
        int cols = heights[0].length;
        Queue<int[]> coords = new LinkedList<>();
        // initialize for squares reachable from pacifics and add them to further explore the grid
        for (int row = 0; row < rows; row++){
            for (int col = 0; col < cols; col++) {
                if (row == 0) {
                    reachPac[row][col] = true;
                    coords.offer(new int[]{row, col});
                }
                else if (col == 0){
                    reachPac[row][col] = true;
                    coords.offer(new int[]{row, col});
                }
            }
        }
        // parse through the rest
        while (!coords.isEmpty()) {
            int[] coord = coords.poll();
            int row = coord[0];
            int col = coord[1];

            // explore 4 directions, if there is a square that has not been marked and has a heigher
            // height than current one, then mark it as true and enqueue the coord
            if (row-1 >= 0 && heights[row-1][col] >= heights[row][col]) {
                if (reachPac[row-1][col] == false) {
                    reachPac[row-1][col] = true;
                    coords.offer(new int[]{row-1, col});
                }
            }
            if (col- 1 >= 0 && heights[row][col-1] >= heights[row][col]) {
                if (reachPac[row][col-1] == false) {
                    reachPac[row][col-1] = true;
                    coords.offer(new int[]{row, col-1});
                }
            }
            if (row+1 < rows && heights[row+1][col] >= heights[row][col]) {
                if (reachPac[row+1][col] == false) {
                    reachPac[row+1][col] = true;
                    coords.offer(new int[]{row+1, col});
                }
            }
            if (col+1 < cols && heights[row][col+1] >= heights[row][col]) {
                if (reachPac[row][col+1] == false) {
                    reachPac[row][col+1] = true;
                    coords.offer(new int[]{row, col+1});
                }
            }
        }

    }


    private static void canReachAtl(int[][] heights, boolean[][] reachAtl) {
        int rows = heights.length;
        int cols = heights[0].length;
        Queue<int[]> coords = new LinkedList<>();
        // same goes for atlantic
        for (int row = 0; row < rows; row++){
            for (int col = 0; col < cols; col++) {
                if (row == rows-1) {
                    reachAtl[row][col] = true;
                    coords.offer(new int[]{row, col});
                }
                else if (col == cols -1){
                    reachAtl[row][col] = true;
                    coords.offer(new int[]{row, col});
                }
            }
        }


        // parse through the rest
        while (!coords.isEmpty()) {
            int[] coord = coords.poll();
            int row = coord[0];
            int col = coord[1];

            // explore 4 directions, if there is a square that has not been marked and has a heigher
            // height than current one, then mark it as true and enqueue the coord
            if (row-1 >= 0 && heights[row-1][col] >= heights[row][col]) {
                if (reachAtl[row-1][col] == false) {
                    reachAtl[row-1][col] = true;
                    coords.offer(new int[]{row-1, col});
                }
            }
            if (col- 1 >= 0 && heights[row][col-1] >= heights[row][col]) {
                if (reachAtl[row][col-1] == false) {
                    reachAtl[row][col-1] = true;
                    coords.offer(new int[]{row, col-1});
                }
            }
            if (row+1 < rows && heights[row+1][col] >= heights[row][col]) {
                if (reachAtl[row+1][col] == false) {
                    reachAtl[row+1][col] = true;
                    coords.offer(new int[]{row+1, col});
                }
            }
            if (col+1 < cols && heights[row][col+1] >= heights[row][col]) {
                if (reachAtl[row][col+1] == false) {
                    reachAtl[row][col+1] = true;
                    coords.offer(new int[]{row, col+1});
                }
            }
        }
    }
}
