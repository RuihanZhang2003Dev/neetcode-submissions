class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        /*
        idea: use bottom up approach: go from the back to the front, go through each word every time
        we move once toward the head, check if starting from this position, we can form a word that 
        is in the dictionary keep doing it until we reach the beginning of the word
        */

        int len = s.length();
        boolean[] canForm = new boolean[len + 1];
        canForm[len] = true;    // base case: no string to iterate through

        for (int i = len -1 ; i >= 0; i--) {
            for (String w: wordDict) {
                if ((i + w.length()) <= s.length() && 
                s.substring(i, i+ w.length()).equals(w)) {
                    canForm[i] = canForm[i + w.length()];
                }
                if (canForm[i]) {
                    break;
                }
            }
        }
         
        return canForm[0];  // can we form the whole word
    }
}
