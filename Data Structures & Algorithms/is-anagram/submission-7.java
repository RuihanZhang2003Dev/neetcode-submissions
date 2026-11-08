class Solution {
    public boolean isAnagram(String s, String t) {
        // idea: use frequency map, add for s, and reduce for t
        // if s and t not same length return false
        if (s.length() != t.length()) return false;
        int[] freq = new int[26];
        int len = s.length();
        for (int i = 0; i< len; i++) {
            char c = s.charAt(i);
            freq[c -'a']++;
        }
        for (int i = 0; i< len; i++) {
            char c= t.charAt(i);
            if (freq[c - 'a'] == 0) return false;
            freq[c-'a']--;
        }
        return true;
    }
}
