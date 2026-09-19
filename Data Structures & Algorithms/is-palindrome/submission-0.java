class Solution {
    public boolean isPalindrome(String s) {
        /*
        idea: use 2 pointers, one pointing from left and one pointing from right
        check if the pointer is pointing toward the alphanumeric character before
        proceeding to compare
        */

        int left = 0;
        int right = s.length() -1;

        while (left < right){
            if (!(Character.isLetter(s.charAt(left)) || 
            Character.isDigit(s.charAt(left)))) {
                left++;
                continue;
            }

            if (!(Character.isLetter(s.charAt(right)) || 
            Character.isDigit(s.charAt(right)))) {
                right--;
                continue;
            }

            if (Character.toLowerCase(s.charAt(left)) != 
            Character.toLowerCase(s.charAt(right))) return false;
            left++;
            right--;
        }
        return true;
    }
}
