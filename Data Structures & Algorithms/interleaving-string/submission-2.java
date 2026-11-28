class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        /*
        idea: |n - m| <= 1 will always be true if s3 is an interleaving string of s1 and s2. use 
        bottom up dp 
        */
        int len1 = s1.length();
        int len2 = s2.length();

        if (s3.length() != len1+ len2) return false;
        boolean[][] dp = new boolean[len1+1][len2+1];
        dp[len1][len2] = true;

        for (int row = len1; row >= 0; row--) {
            for (int col = len2; col >= 0; col--) {
                if (row < len1 && s1.charAt(row) == s3.charAt(row+ col) && dp[row+1][col]) {
                    dp[row][col] = true;
                }
                if (col < len2 && s2.charAt(col) == s3.charAt(row+ col) && dp[row][col+1]) {
                    dp[row][col] = true;
                }
            }
        }
        return dp[0][0];
        
    }
}
