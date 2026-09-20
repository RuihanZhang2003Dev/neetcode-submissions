class Solution {
    public boolean checkInclusion(String s1, String s2) {
        /*
        idea: use sliding window of fixed length of length of s1
        */

        // edge case: if s2 is smaller than s1, then return false, no permutation possible
        if (s2.length() < s1.length()) return false; 
        char[] subC1 = s1.toCharArray();
        Arrays.sort(subC1);
        String subS1 = new String(subC1);

        for (int i = 0; i < s2.length(); i++){
            int l = i;
            int r = i+ s1.length();
            if (r > s2.length()) return false;
                
            char[] subC = s2.substring(l, r).toCharArray();
            Arrays.sort(subC);
            String subS = new String(subC);
            if (subS1.equals(subS)) return true;
        }
        return false;
    }
        
        
}

    
