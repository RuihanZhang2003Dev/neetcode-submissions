class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        /*
        idea: so we would iterate from back to from to see if we can form a word so far, if we can
        then we mark the position  
        */ 
        // make a hashset for easier access to dict
        int len = s.length();
        boolean[] canReach = new boolean[len+1];
        canReach[len] = true;   // when we are at the end of the word,we can reach the end of the word

        for (int i = len -1; i >= 0; i--) {
            // iterate from current letter to see if we can form a word from current letter and
            // if it reaches the end of word
            for (String word: wordDict) {
                int wordLen = word.length();
                if (s.startsWith(word, i)) {
                    canReach[i] = canReach[i+word.length()];
                }
                if (canReach[i]) break;
            }            
        }
        return canReach[0];

    }
}
