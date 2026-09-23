class Solution {
    public boolean isSubsequence(String s, String t) {
        /*
        idea: use 2 pointers, one pointing at s and one pointing at t
        iterate through t, whenever s.charAt(sindex) = t.charAt(tindex) then
        advance pointer at s and t, after iterating, if sindex == s.length()
        then you got subsequence
        */
        if (s.length() > t.length()) return false;
        int sInd = 0;

        for (int i = 0; i< t.length(); i++) {
            if (sInd == s.length()) break;
            if (s.charAt(sInd) == t.charAt(i)) {
                sInd++;
            }
        }
        if (sInd == s.length()) return true;
        return false;
    }
}