class Solution {
    public void solve(char[][] board) {
        /*
        idea: look for Os that are on the boarder, run multi source BFS on them, at each
        iteration, mark Os with T, find all the squares connected to the square on the boarder, 
        then iterate throught the board again to change the remaining Os to Ts and then Ts back
        to Os.
        */

        Queue<int[]> boarderOs = new LinkedList<>();
        int rows = board.length;
        int cols = board[0].length;

        // go through boarders and find the Os on the boarder
        for (int col = 0; col < cols; col++) {
            if (board[0][col] == 'O'){
                board[0][col] = 'T';
                boarderOs.add(new int[]{0, col});
            }
            if (board[rows-1][col] == 'O') {
                board[rows-1][col] = 'T';
                boarderOs.add(new int[]{rows -1, col});
            }
        } 

        for (int row = 1; row < rows -1; row++) {
            if (board[row][0] == 'O') {
                board[row][0] = 'T';
                boarderOs.add(new int[]{row, 0});
            } 
            if (board[row][cols -1] == 'O') {
                board[row][cols -1] = 'T';
                boarderOs.add(new int[]{row, cols-1});
            }
        } 

        while (!boarderOs.isEmpty()) {
            int[] coord = boarderOs.poll();
            int row = coord[0];
            int col = coord[1];

            // check 4 directions
            if (row + 1 < board.length && board[row+1][col] == 'O'){
                board[row+1][col] = 'T';
                boarderOs.add(new int[]{row+1, col});
            }
            if (row - 1 > -1 && board[row -1][col] == 'O'){
                board[row-1][col] = 'T';
                boarderOs.add(new int[]{row-1, col});
            }
            if (col + 1 < board[0].length && board[row][col+1] == 'O'){
                board[row][col+1] = 'T';
                boarderOs.add(new int[]{row, col+1});
            }
            if (col - 1 > -1 && board[row][col -1] == 'O'){
                board[row][col-1] = 'T';
                boarderOs.add(new int[]{row, col-1});
            }
        }

        // after marking all island that connects to the boarder island with Ts, go through all
        // squares on board again and changes Os to Xs, and Ts to Os
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == 'O') board[row][col] = 'X';
                if (board[row][col] == 'T') board[row][col] = 'O';
            }
        }
    }
}
