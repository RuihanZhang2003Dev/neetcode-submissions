class Solution {
    public boolean checkInclusion(String s1, String s2) {
        /*
        idea: build frequency map for 3 chars in s1 and another for 3 chars in s2, if the freq map
        is the same for s1 and s2 at current 3-char window, then return true, other wise return 
        false.
        */

        // if s1 has more length than s2, impossible
        if (s1.length() > s2.length()) return false;
        int len1 =s1.length();
        int len2 = s2.length();
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        
        for (int i = 0; i< len1; i++) {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        int matched = 0;
        for (int i = 0; i < freq1.length; i++) {
            if (freq1[i] == freq2[i]) matched++;
        }
        
        for (int i = 1; i<= (len2 - len1); i++) {
            // if the previous window has same frequency s1 and s2, then return true
            if (matched == 26) return true;

            // if not, remove the first char and add a char to the end to update window
            char removed = s2.charAt(i - 1);
            // if they were initially the same and no longer the same after change, then modify
            if (freq2[removed - 'a'] == freq1[removed - 'a']) {
                matched--;
                freq2[removed - 'a']--;
            }
            // if by changing, they become the same, modify
            else if (freq2[removed - 'a'] -1 == freq1[removed - 'a']) {
                matched++;
                freq2[removed - 'a']--;
            }
            else freq2[removed - 'a']--;
            
            char added = s2.charAt(i +len1 -1);
            if (freq2[added -'a'] == freq1[added -'a']) {
                matched--;
                freq2[added -'a']++;
            }
            else if (freq2[added -'a'] + 1 == freq1[added -'a']) {
                matched++;
                freq2[added -'a']++;
            }
            else freq2[added -'a']++;
        }
        return Arrays.equals(freq1, freq2);
    }
}
