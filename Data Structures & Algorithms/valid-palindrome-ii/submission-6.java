class Solution {
    public boolean validPalindrome(String s) {
        // idea: when encountered with a different char, check which pointer to move to form a valid 
        // palindrome, if by moving them will not form the palin, then return false.

        int left = 0;
        int right = s.length() -1;
        while (left < right) {
            char leftC = s.charAt(left);
            char rightC = s.charAt(right);

            if (leftC != rightC) {
                // check which pointer to move, if neither can solve the issue, return false
                return (isPalin(left +1, right, s) || isPalin(left, right -1, s));
            }
            else {
                left++;
                right--;
            }
        }
        return true;
    }

    private boolean isPalin(int left, int right, String s) {
        int l = left;
        int r = right;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}