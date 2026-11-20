class Solution {
    public int numDecodings(String s) {
        /*
        idea: start by end, use bottom up dp to store the number of ways to reach form the future 
        code with the current digits being fixed
        */
        int len = s.length();
        int[] ways = new int[len+1];
        ways[len] = 1;  // base case: ways to decode the empty string is 1
        
        for (int i = len-1; i >= 0; i--) {
            char cur = s.charAt(i);
            if (cur == '0') {
                ways[i] = 0;
            }
            else{
                ways[i] = ways[i+1];
                //  if there is a next number and if the current char is 1, add the number of ways 
                // to decode the rest of string with 1 and its next num fixed. if the current char
                // is 2, then you have to make sure its next num is < 7 before doing the same
                if (i+1 < len && (cur == '1' || (cur == '2' && s.charAt(i + 1) - '0'< 7))) {
                    ways[i] += ways[i+2];
                }
            }
        }
        return ways[0];
    }
}
