class Solution {
    public boolean isPalindrome(String s) {
        /*
        idea: use 2 pointers, one pointing at left most and one pointing at right most, make sure 
        that left and right pointers are pointing to an alphanumeric before comparing them
        */

        int left = 0;
        int right = s.length() -1;
        while (left < right) {
            char l = s.charAt(left);
            char r = s.charAt(right);

            if (!Character.isLetterOrDigit(l)) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(r)) {
                right--;
                continue;
            }

            if (Character.isLetter(l) && Character.isLetter(r)) {
                if (Character.toLowerCase(l) != Character.toLowerCase(r)) return false;
                else {
                    left++;
                    right--;
                }
            }
            else if (Character.isDigit(l) && Character.isDigit(r)) {
                if (l != r) return false;
                else {
                    left++;
                    right--;
                }
            }
            else return false;
        }
        return true;
    }
}
