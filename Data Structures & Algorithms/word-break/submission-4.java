class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        /*
        idea: use bottom up approach: go from the back to the front, go through each word every time
        we move once toward the head, check if starting from this position, we can form a word that 
        is in the dictionary keep doing it until we reach the beginning of the word
        */
        Set<String> words = new HashSet<>(wordDict);
        int len = s.length();
        boolean[] canForm = new boolean[len + 1];
        canForm[len] = true;    // base case: no string to iterate through

        for (int i = len -1 ; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                String word = s.substring(i, j+ 1);
                    if (words.contains(word) && canForm[i + word.length()]) {
                        canForm[i] =true;
                        break;
                    }
            }
        }
         
        return canForm[0];  // can we form the whole word
    }
}
