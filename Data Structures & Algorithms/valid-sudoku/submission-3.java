class Solution {
    public boolean isValidSudoku(char[][] board) {
        /*
        idea: we can have 9 hash tables representing the 3x3 and we index it by taking row/3 col/3
        9 rows and 9 cols to have easy access, if at one point the sudoku becomes invalid, return
        false.
        */
        List<HashSet<Character>> rows = new ArrayList<>();
        List<HashSet<Character>> cols = new ArrayList<>();
        List<HashSet<Character>> squares = new ArrayList<>();

        for (int i = 0; i< 9; i++) {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
            squares.add(new HashSet<>());
        }

        for (int row = 0; row < rows.size(); row++) {
            for (int col = 0; col < cols.size(); col++) {
                char cur = board[row][col];
                if (cur == '.') continue;
                int square_ind = ((row/3) *3) + col/3;
                if (rows.get(row).contains(cur) ||
                cols.get(col).contains(cur) ||
                squares.get(square_ind).contains(cur)) {
                    return false;
                }
                rows.get(row).add(cur);
                cols.get(col).add(cur);
                squares.get(square_ind).add(cur);
            }
        }
        return true;
    }
}
