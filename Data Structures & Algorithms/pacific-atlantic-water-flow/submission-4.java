class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        /*
        idea: the clear way to do this is to have 2 arrays to check which square reaches one of 
        the ocean, go through all the squares, then get their intersection 
        */

        List<List<Integer>> result = new ArrayList<>();
        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] reachPacific = new boolean[rows][cols];
        boolean[][] reachAtlantic = new boolean[rows][cols];

        // perform 2 searches, same as rotting fruit
        reach_Pac(heights, reachPacific);
        reach_Atl(heights, reachAtlantic);

        for (int row = 0; row< rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (reachPacific[row][col] && reachAtlantic[row][col]) {
                    result.add(List.of(row, col));
                }
            }
        }
        return result;
    }

    private void reach_Pac(int[][] heights, boolean[][] reach) {
        Queue<int[]> reached = new LinkedList<>();

        // take the first col, add all to the queue
        for (int row = 0; row < heights.length; row++) {
            reached.add(new int[]{row, 0});
            reach[row][0] = true;
        }

        // take the first row
        for (int col = 1; col < heights[0].length; col++) {
            reached.add(new int[]{0, col});
            reach[0][col] = true;
        }

        while (!reached.isEmpty()) {
            int size = reached.size();
            for (int i = 0; i< size; i++) {
                int[] coord = reached.poll();
                int row = coord[0];
                int col = coord[1];

                // go all 4 directions
                if (row + 1 < heights.length && heights[row + 1][col] >= heights[row][col]) {
                    if (reach[row + 1][col] == false) {
                        reach[row + 1][col] = true;
                        reached.add(new int[]{row+1, col});
                    }
                }
                if (col + 1 < heights[0].length && heights[row][col+1] >= heights[row][col]){
                    if (reach[row][col+ 1] == false) {
                        reach[row][col + 1] = true;
                        reached.add(new int[]{row, col+ 1});
                    }
                }

                if (row - 1 > -1 && heights[row - 1][col] > heights[row][col]) {
                    if (reach[row - 1][col] == false) {
                        reach[row - 1][col] = true;
                        reached.add(new int[]{row-1, col});
                    }
                }
                if (col - 1> -1 && heights[row][col-1] > heights[row][col]){
                    if (reach[row][col - 1] == false) {
                        reach[row][col - 1] = true;
                        reached.add(new int[]{row, col- 1});
                    }
                }
            }     
        }
    }

    private void reach_Atl(int[][] heights, boolean[][] reach) {
        Queue<int[]> reached = new LinkedList<>();

        // take the last col, add all to the queue
        for (int row = 0; row < heights.length; row++) {
            reached.add(new int[]{row, heights[0].length -1});
            reach[row][heights[0].length -1] = true;
        }

        // take the last row
        for (int col = 0; col < heights[0].length-1; col++) {
            reached.add(new int[]{heights.length -1, col});
            reach[heights.length -1][col] = true;
        }

        while (!reached.isEmpty()) {
            int size = reached.size();
            for (int i = 0; i< size; i++) {
                int[] coord = reached.poll();
                int row = coord[0];
                int col = coord[1];

                
                if (row + 1 < heights.length && heights[row + 1][col] >= heights[row][col]) {
                    if (reach[row + 1][col] == false) {
                        reach[row + 1][col] = true;
                        reached.add(new int[]{row+1, col});
                    }
                }
                if (col + 1 < heights[0].length && heights[row][col+1] >= heights[row][col]){
                    if (reach[row][col+ 1] == false) {
                        reach[row][col + 1] = true;
                        reached.add(new int[]{row, col+ 1});
                    }
                }
               
                if (row - 1 > -1 && heights[row - 1][col] >= heights[row][col]) {
                    if (reach[row - 1][col] == false) {
                        reach[row - 1][col] = true;
                        reached.add(new int[]{row-1, col});
                    }
                }
                if (col - 1> -1 && heights[row][col-1] >= heights[row][col]){
                    if (reach[row][col - 1] == false) {
                        reach[row][col - 1] = true;
                        reached.add(new int[]{row, col- 1});
                    }
                }

            }     
        }
    }


}
