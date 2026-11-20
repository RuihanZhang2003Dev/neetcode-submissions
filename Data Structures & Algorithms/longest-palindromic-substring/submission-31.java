class Solution {
    public String longestPalindrome(String s) {
        /*
        idea: at each char, expand left and right to check for palindrome by considering one char in 
        the middle, and then consider current char and next char as middle, expand again to see if
        there is palindrome
        */
        int len = s.length();
        if (len <= 1) return s;
        int resLen = 0;
        String res = "";

        
        for (int i =0; i< len; i++) {
            // perform 
            int left = i;
            int right = i;
            while (left >=0 && right < len && s.charAt(left) == s.charAt(right)) {
                if (right -left +1 > resLen) {
                    resLen = right- left+1;
                    res = s.substring(left, right+1);
                }
                left--;
                right++;
            }
            left = i;
            right = i+1;
            while (left >=0 && right < len && s.charAt(left) == s.charAt(right)) {
                if (right -left +1 > resLen) {
                    resLen = right- left+1;
                    res = s.substring(left, right+1);
                }
                left--;
                right++;
            }
        }
        return res;
    }
    
}
