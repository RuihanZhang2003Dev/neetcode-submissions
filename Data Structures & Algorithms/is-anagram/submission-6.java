class Solution {
    public boolean isAnagram(String s, String t) {
        // idea: use an array to store the frequency of the 26 letters
        // populate it with s, depopulate it with t, stop when a letter 
        // reaching for negative frequency

        // edge case: s and t not the same length, impossible that they are anagram
        if (s.length() != t.length()) return false;

        int[] freq = new int[26];
        for (int i = 0; i< s.length(); i++) freq[s.charAt(i) - 'a']++;

        for (int j = 0; j< s.length(); j++) {
            if (freq[t.charAt(j) - 'a'] == 0) return false; 
            freq[t.charAt(j) - 'a']--;
        }
        return true;
    }
}
