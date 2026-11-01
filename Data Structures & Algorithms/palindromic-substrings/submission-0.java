class Solution {
    int result = 0;
    public int countSubstrings(String s) {
        /*
        idea: iterate using 2 pointers, if the current substring is a palindrome, expand left
        and right. Note that do it with even windows and with odd windows. move right when we 
        have checked all possible substring from that position
        */

        for (int l = 0; l< s.length(); l++) {
            helper(s, l, l);    // odd 2pointers
            helper(s, l, l + 1);    // even 2 pointers
        }
        return result;
    }
    
    // private helper
    private void helper(String s, int left, int right){
        while ((left >= 0 && right < s.length()) && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            result++;
        }
    }
}
