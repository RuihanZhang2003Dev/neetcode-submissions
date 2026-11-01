class Solution {
    public String longestPalindrome(String s) {
        /*
        idea: can use dp with memoization with bottom up approach. However, the time complexity
        will remain O(n^2) with space complexity of O(n^2) since we would need a 2D dp array.
        So we will use 2 pointers to solve this problem, since it uses less space complexity 
        than dp with not using memoization. We would need to check even length and uneven length
        at each iteration 
        */

        int resLen = 0;
        String res = "";

        for (int i = 0; i< s.length(); i++) {
            // odd length palindrome
            int left = i;
            int right = i;
            while ((left >= 0 && right < s.length()) && (s.charAt(left) == s.charAt(right))) {
                if (resLen < right - left + 1) {
                    resLen = right - left + 1;
                    res = s.substring(left, right+1);
                }
                left--;
                right++;
            }

            // even length palindrome
            left = i;
            right = i + 1;
            while ((left >= 0 && right < s.length()) && (s.charAt(left) == s.charAt(right))) {
                if (resLen < right - left + 1) {
                    resLen = right - left + 1;
                    res = s.substring(left, right+1);
                }
                left--;
                right++;
            }
        }
        return res;
    }
}
