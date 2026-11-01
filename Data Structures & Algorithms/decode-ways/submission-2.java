class Solution {
    public int numDecodings(String s) {
        /*
        idea: use dp bottom-up, build result from scratch. the result will either be the prev
        result or the sum of prev result + the result before that (if the char at prev result can
        expand to 2 characters(so if char == 1 or char == 2 and char at i + 1 < 7)), that would 
        include all the possibilities
        */

        int[] ways = new int[s.length() +1];
        ways[s.length()] = 1;

        for (int i = s.length() -1; i >= 0; i--) {
            if (s.charAt(i) == '0') ways[i] = 0;
            else {
                ways[i] = ways[i + 1];

                if (i + 1 < s.length() && 
                (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) < '7'))) {
                    ways[i] += ways[i + 2];
                }   
            }  
        }
        return ways[0];
    }
}
