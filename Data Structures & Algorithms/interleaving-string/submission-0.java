class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        /*
        idea: |n -m| <= 1 will always be true if s3 is formed by interleaving s1 and s2 together, since
        in order to form s3, s1 will have n substrings, and between those substrings, have to be 
        substrings of n-1 at least, if substrings of s1 does not have substring from s2 in between, they
        would just be 1 substring instead of multiple.

        if the length of s1 and s2 combined does not match the length of s3, then return false, since 
        they cannot form s3

        otherwise perform bottom up dp approach: start from the end of the strings, check if the char 
        we are currently pointing to is one of the char we are pointing in one of the strings, if not,
        put false on it, other wise put true, make a 2d grid
        */
        
        int len1 = s1.length();
        int len2 = s2.length();

        if (len1 + len2 != s3.length()) return false;
        // +1s are important as the base case is the result after after going through the whole s3
        boolean[][] dp = new boolean[len1 +1][len2 + 1];
        dp[len1][len2] = true;

        // construct dp array
        for (int i = len1; i >= 0; i--) {
            for(int j = len2; j >= 0; j--) {
                if (i < len1 && s1.charAt(i) == s3.charAt(i + j) && dp[i + 1][j]) {
                    dp[i][j] = true;
                }
                if (j < len2 && s2.charAt(j) == s3.charAt(i + j) && dp[i][j+ 1]) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[0][0];
    }
}
