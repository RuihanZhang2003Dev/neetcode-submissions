class Solution {
    public int lengthOfLongestSubstring(String s) {
        /*
        idea: use sliding window, start at the beginning, expand the window when right 
        encounters an unique character, and shrunk the window when right encounters a 
        repeating character, use a hashset to keep track of the unique characters
        */

        // edge case: s is of length 0;
        if (s.length() == 0) return 0;

        HashSet<Character> unique = new HashSet<>();
        int l = 0;
        int maxLength= 1;
        for (int r = 0; r< s.length(); r++){
            if (unique.contains(s.charAt(r))){
                maxLength = Math.max(maxLength, unique.size());
                while (s.charAt(l) != s.charAt(r)){
                    unique.remove(s.charAt(l));
                    l++;
                }
                l++;
            }
            else {
                unique.add(s.charAt(r));
                maxLength = Math.max(maxLength, unique.size());
            }
            
        }
        return maxLength;
    }
}
