class Solution {
    public int lengthOfLongestSubstring(String s) {
        /*
        idea: use dynamic sliding window, if the current window does not have duplicate, expand, and
        when we encounter a duplicate within the window, shrink from left until there is no more 
        current char, use a hashset to store the char in window
        */
        Set<Character> window = new HashSet<>();
        int left = 0;
        int right = 0;
        int maxLen = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            while (window.contains(c)) {
                window.remove(s.charAt(left));
                left++;
            }
            window.add(c);
            maxLen = Math.max(maxLen, right-left +1);
            right++;
        }
        return maxLen;
    }
}
