class Solution {
    public int characterReplacement(String s, int k) {
        /*
        idea: use sliding window, always try to expand the window, keep track of the most 
        frequent character, it the window length - frequency of the most reccuring character, 
        then shrink the window until the conditions meets
        */

        int[] freq = new int[26];
        int l = 0;
        int r = 0;
        int maxLength = 0;
        while (r< s.length()){
            freq[s.charAt(r) - 'A']++;
            while ((r - l + 1) - getMostFreq(freq) > k) {
                freq[s.charAt(l) - 'A']--;
                l++;
            }
            maxLength = Math.max((r-l +1), maxLength);
            r++;
        }
        return maxLength;
    }

    public static int getMostFreq(int[] freq){
        int max = 0;
        for (int i =0; i< freq.length; i++){
            max = Math.max(freq[i], max);
        }
        return max;
    }
}
