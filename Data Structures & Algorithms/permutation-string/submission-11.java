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
        
        for (int i = 1; i<= (len2 - len1); i++) {
            // if the previous window has same frequency s1 and s2, then return true
            if (Arrays.equals(freq1, freq2)) return true;

            // if not, remove the first char and add a char to the end to update window
            freq2[s2.charAt(i -1) -'a']--;
            freq2[s2.charAt(i +len1 -1) -'a']++;
        }
        return Arrays.equals(freq1, freq2);
    }
}
