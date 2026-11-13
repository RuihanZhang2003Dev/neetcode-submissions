class Solution {
    public boolean exist(char[][] board, String word) {
        /*
        idea: backtrack, when encounter the start of the word, start exploring, when we find the 
        whole word, return true
        */
        boolean found = false;
        int rows = board.length;
        int cols =  board[0].length;
        for (int row = 0; row< rows; row++){
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == word.charAt(0)) {
                    boolean[][] visited = new boolean[rows][cols];
                    found = find(board, visited, row, col, word, 0);
                }
                if (found) return true;
            }
        }
        return found;
    }

    private boolean find(char[][] board, boolean[][] visited, int row, int col, String word, int ind) {
        if (ind >= word.length()) return true;
        // if out of bound, or alredy visited, or the current one does not match, return false
        if (row >= board.length || row < 0 || col >= board[0].length || col < 0 || visited[row][col] 
        || board[row][col] != word.charAt(ind)) return false;
        else {
            visited[row][col] = true;
            // explore 4 directions
            boolean res = find(board, visited, row +1, col, word, ind+1) ||
            find(board, visited, row -1, col, word, ind+1) ||
            find(board, visited, row, col+1, word, ind+1) ||
            find(board, visited, row, col-1, word, ind+1);
            visited[row][col] = false;
            return res;
        }
    }
}
