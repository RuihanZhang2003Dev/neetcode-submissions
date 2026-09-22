class Solution {
    public boolean exist(char[][] board, String word) {
        /*
        idea: use backtracking, mark the place we have explored during current iteration with
        '#', then un mark it when the iteration is done, start at each square to explore all 
        possibilities 
        */
        for (int row = 0; row< board.length; row++){
            for (int col = 0; col < board[0].length; col++){
                if (dfs(board, word, row, col, 0)) return true;
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, String word, int row, int col, int ind){
        if (ind == word.length()) return true;
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) return false;
        if (board[row][col] != word.charAt(ind)) return false;
        
        char tmpC = board[row][col];
        board[row][col] = '#';

        boolean found = (dfs(board, word, row+1, col, ind+1) ||
            dfs(board, word, row-1, col, ind+1) ||
            dfs(board, word, row, col+1, ind+1) ||
            dfs(board, word, row, col-1, ind+1));

        board[row][col] = tmpC;

        return found;


    }
}
