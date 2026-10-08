class Solution {
    public boolean isValidSudoku(char[][] board) {
        /*
        idea: brute force would be, for each square, check row, check column,
        check 3x3. very inefficient.
        */
        // to keep track of which square we are checking
        int curRow = 0;
        int curCol = 0;

        while (curRow < board.length){  
            if (curCol == board[0].length){
                curRow++;
                curCol = 0;
                continue;
            }
            if (board[curRow][curCol] == '.') {
                curCol++;
                continue;
            }

            char curNum = board[curRow][curCol];
            // check for same column
            for (int row = 0; row< board.length; row++){
                if (row == curRow) continue;
                if (board[row][curCol] == curNum) return false;
            }
            // check for same row
            for (int col = 0; col < board[0].length; col++){
                if (col == curCol) continue;
                if (board[curRow][col] == curNum) return false;
            }

            int startRow = curRow - (curRow % 3);
            int startCol = curCol - (curCol % 3);

            // check for 3x3
            for (int row = startRow; row < startRow + 3; row++){
                for (int col = startCol; col < startCol + 3; col++){
                    if (row == curRow && col == curCol) continue;
                    if (board[row][col] == board[curRow][curCol]) return false;
                }
            }
            curCol++;
        }
        return true;
        
    }
}
