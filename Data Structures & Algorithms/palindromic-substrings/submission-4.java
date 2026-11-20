class Solution {
    int count = 0;
    public int countSubstrings(String s) {
        /*
        idea: all we had to do is to count the substring, so we keep a global count and expand even
        palindrome and odd palindrome at each character
        */
        for (int i= 0; i< s.length(); i++) {
            helper(s, i, i);
            helper(s, i, i+1);
        }
        return count;
    }
    private void helper(String s, int start, int end) {
        int left = start;
        int right = end;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
    }
}
