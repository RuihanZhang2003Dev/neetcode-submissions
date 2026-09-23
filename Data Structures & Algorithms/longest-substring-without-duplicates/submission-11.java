class Solution {
    public int lengthOfLongestSubstring(String s) {
        /*
        idea: use dynamic sliding window, so it moves. expand the right side when it is a unique
        character and shrink left until you find the duplicate when you do. use hashset to store
        the unique characters.
        */
        if (s.length() < 2) return s.length();

        HashSet<Character> used = new HashSet<>();
        int l = 0;
        int r = 0;
        int maxLength = 0;
        while (r< s.length()){
            while (!used.isEmpty() && used.contains(s.charAt(r))) {
                used.remove(s.charAt(l));
                l++;
            }
            used.add(s.charAt(r));
            maxLength = Math.max(r - l +1, maxLength);
            r++;
        }
        return maxLength;
    }
}
