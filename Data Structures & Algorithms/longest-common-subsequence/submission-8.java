class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        /*
        idea: 2d dp, use bottom up. compare the character, if the current one is equal, then advance
        both pointers(so get the diagonal), if not, then get the max of go right or go down(advance
        one of the word)
        */
        int len1 = text1.length();
        int len2 = text2.length();

        int[][] longest = new int[len1+1][len2+1];

        for (int row = len1 -1; row >= 0; row--) {
            for (int col = len2 -1; col >= 0; col--) {
                if (text1.charAt(row) == text2.charAt(col)) {
                    longest[row][col] = 1+ longest[row+1][col+1];
                }
                else longest[row][col] = Math.max(longest[row+1][col], longest[row][col+1]);
            }
        }
        return longest[0][0];
    }
}
