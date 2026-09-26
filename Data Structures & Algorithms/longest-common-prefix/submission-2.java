class Solution {
    public String longestCommonPrefix(String[] strs) {
        /*
        idea: sort the string, then compare the first and last word, to find the
        longest common prefix
        */
        Arrays.sort(strs);
        int lCP = Integer.MAX_VALUE;
        String result = "";
        for (int i = 0; i< strs.length; i++) lCP = Math.min(lCP, strs[i].length());
        for (int i = 0 ; i< lCP; i++){
            if (strs[0].charAt(i) == strs[strs.length -1].charAt(i)) result += strs[0].charAt(i);
            else break;
        }
        return result;
    }
}