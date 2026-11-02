class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        /*
        idea: use bottom up, start from the end of the string and work our way up until the 
        start of the string, if the character matches, the grid will have the number 1 + 
        (grid[row + 1][col + 1]) diagonal since we are moving forward with both letters, if not,
        the grid will take the max of right grid and bottom grid, since we can either move forward
        with text 1 or text 2. so we take the longest lcs of them. 
        */
        int[][] grid = new int[text1.length() + 1][text2.length() + 1];

        for (int row = text1.length() -1; row >= 0; row--) {
            for (int col = text2.length() -1; col >= 0 ; col--) {
                if (text1.charAt(row) == text2.charAt(col)) {
                    // if they are equal, move diagonally as we move forward with both words
                    grid[row][col] = 1+ grid[row+1][col +1];
                }
                else grid[row][col] = Math.max(grid[row+1][col], grid[row][col+1]);
            }
        }
        return grid[0][0];
    }
}
