class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        /*
        idea: use bottom-up DP, we start from the end of the string, use the end of the string as base
        case for memoization. At each position, check if a word from the dictionary can be formed, if so,
        the boolean at current position will be the same as the boolean at the position right after the 
        end of the word of dictionary in the original string
        */
        int len = s.length();
        boolean[] dp = new boolean[len +1];
        dp[len] = true; // base case: no more string to read from

        for (int i = len -1; i >= 0; i--) {
            for (String w: wordDict) {
                int wordLen = w.length();
                // here <= len since dp[len] is the base case here
                if ((i+ wordLen <= len) && (s.substring(i, i+ wordLen).equals(w))) {
                    dp[i] = dp[i+ wordLen];
                }
                // if it forms a word and it reaches the end, break, no need to check other words
                if (dp[i]) {    
                    break;
                }
            }
        }
        return dp[0];
    }
}
