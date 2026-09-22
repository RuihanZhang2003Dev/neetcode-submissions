class Solution {
    public int lengthOfLongestSubstring(String s) {
        /*
        idea: use sliding window, expand the window when we encounter an unique
        character, shrink it when there is a repeating character, keep track of 
        max length, use a hashset to keep track of the unique characters
        */

        HashSet<Character> usedChar = new HashSet<>();
        int l = 0;
        int r = 0;
        int maxLength = 0;

        for (int i = 0; i< s.length();i++) {
            if (usedChar.isEmpty() || !usedChar.contains(s.charAt(i))) {
                usedChar.add(s.charAt(i));
                maxLength = Math.max(maxLength, usedChar.size());
                r++;
            }
            
            else {
                while (s.charAt(l) != s.charAt(i)){
                    usedChar.remove(s.charAt(l));
                    l++;
                }
                l++;
                r++;
            }
        }
        return maxLength;
    }
}
