class Solution {
    public boolean exist(char[][] board, String word) {
        /*
        idea: use backtracking, explore left right up and down, pass down the word in making,
        during recursion
        */
        for (int row = 0; row< board.length; row++){
            for (int col = 0; col< board[0].length; col++){
                if (helper(board, word, row, col, 0)) return true;
            }
        }
        return false;
    }

    public static boolean helper(char[][] board, String word, int row, int col, int ind) {
        if (ind == word.length()) return true;
        if (row >= board.length || col >= board[0].length || row < 0 || col < 0) return false;
        if (board[row][col] != word.charAt(ind)) return false;

        char tmp = board[row][col];
        board[row][col] = '#';
        boolean found = (helper(board, word, row +1, col, ind+1)||
            helper(board, word, row -1, col, ind+1)||
            helper(board, word, row, col +1, ind+1)||
            helper(board, word, row, col -1, ind+1)); 

        board[row][col] = tmp;

        // explore 4 directions
        return found;
    }
}
