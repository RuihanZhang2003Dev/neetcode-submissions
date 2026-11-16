class Solution {
    public void solve(char[][] board) {
        /*
        idea: find the islands taht starts on the border, then use multisources bfs to find and mark
        the whole island that has squares on the border, then we iterate throught the whole grid
        and finally turn the marked islands squares back to O
        */

        int rows = board.length; 
        int cols = board[0].length;
        Queue<int[]> coords = new LinkedList<>();

        // find all island squares on the border and mark them
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col< cols; col++) {
                if (row == 0 || row == rows -1 || col == 0 || col == cols -1) {
                    if (board[row][col]== 'O') {
                        board[row][col] = 'T';
                        coords.offer(new int[]{row, col});
                    }
                }
            }
        }
        // find all island squares that are connected to island squares in the border
        while (!coords.isEmpty()) {
            int[] coord = coords.poll();
            int row = coord[0];
            int col = coord[1];

            if (row -1 >= 0 && board[row-1][col] == 'O') {
                board[row-1][col] = 'T';
                coords.offer(new int[]{row -1, col});
            }
            if (col -1 >= 0 && board[row][col-1] == 'O') {
                board[row][col-1] = 'T';
                coords.offer(new int[]{row, col-1});
            }
            if (row +1 < rows && board[row+1][col] == 'O') {
                board[row+1][col] = 'T';
                coords.offer(new int[]{row +1, col});
            }
            if (col + 1< cols && board[row][col+1] == 'O') {
                board[row][col+1] = 'T';
                coords.offer(new int[]{row, col+1});
            }
        }

        // one last scan to turn O to X and T to O
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == 'O') {
                    board[row][col] = 'X';
                }
                else if (board[row][col] == 'T') {
                    board[row][col] = 'O';
                }
            }
        }
    }
}
