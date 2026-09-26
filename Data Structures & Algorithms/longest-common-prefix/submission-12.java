class Solution {
    public String longestCommonPrefix(String[] strs) {
        /*
        idea: get max len and min len, and then compare them for the lcp
        */
        StringBuilder result = new StringBuilder();
        int maxInd = 0;
        int minInd = 0;
        int maxLen = strs[0].length();
        int minLen = strs[0].length();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < minLen) {
                minInd = i;
                minLen = strs[i].length();
            }
            else {
                maxInd = i;
                maxLen = strs[i].length();
            }
        }
        String minWord = strs[minInd];
        String maxWord = strs[maxInd];

        for (int i = 0; i< minLen; i++){
            if (minWord.charAt(i) != maxWord.charAt(i)){
                return result.toString();
            }
            result.append(minWord.charAt(i));
        }
        if (minLen == maxLen) return minWord;
        return result.toString();
    }
}