class Solution {
    public int minDistance(String word1, String word2) {
        /*
        idea: have to convert word1 to word2, this is an extension of the problem Longest Common 
        Subsequence. So we cannot change word 2, we can only work on word 1. we use bottom up, starting
        from the end, if we encounter a character that was not equal, we can either: 1. insert, that 
        that means we are going to insert a character that is equal to the current char of word2, hence
        we will move onto the next character of word2. 2. delete, that means we are going to delete the 
        current character word1 by ignoring it and move onto the character of word 1. 3. replace, that
        means we are going to replace the current character in word1 as a character equal to the current 
        char in word2. hence we will move forward with both words. Do not forget to increase the number
        of steps at each iteration. (if we perform an action)
        base case: if either we are done with word 1 or we are done with word 2, if there are still 
        letters left in the other word, then we have to increase the step by that much, since we have
        to either insert or delete in word 1. 
        */

        int len1 = word1.length();
        int len2 = word2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];
        dp[len1][len2] = 0;
        for (int i = 0; i < len1; i++) {
            dp[i][len2] = len1 -i;  // base case: when all of second word is used up
        } 

        for (int i = 0; i< len2; i++) {
            dp[len1][i] = len2 -i;  // base case: when all of first word are used up
        }

        for (int i = len1 -1; i >= 0; i--) {
            for (int j = len2 -1; j >= 0; j--) {
                // if they are equal, advance both words
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                }
                else {
                    // 3 choices: insert, so go down, delete, go right, replace diagonal
                    int insert = dp[i+ 1][j];
                    int delete = dp[i][j+ 1];
                    int replace = dp[i+ 1][j + 1];

                    dp[i][j] = 1+ Math.min(insert, Math.min(delete, replace));
                }
            }
        }
        return dp[0][0];

    }
}
