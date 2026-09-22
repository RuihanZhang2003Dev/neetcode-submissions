class Solution {
    public int characterReplacement(String s, int k) {
        /*
        idea: use a sliding window to check if the letters inside fits the condition, which is
        modify less than k letters to get a repeating character. use an array to store 
        frequency, at each letter updates the frequency of the most frequent char, if the size
        of the window - most frequent char > k then remove from left until it is <= k
        */
        int[] freq= new int[26];
        int maxLength =0;
        int l = 0;
        int mostFreq = 0;
        for (int r =0; r< s.length(); r++){
            freq[s.charAt(r) - 'A']++;
            mostFreq = Math.max(mostFreq, freq[s.charAt(r) - 'A']);

            // if the size of window - mostFreq > k, then shrink from left
            while ((r - l + 1) - mostFreq > k) {
                freq[s.charAt(l) - 'A']--;
                l++;
            }

            maxLength= Math.max(maxLength, r-l+1);
        }
        return maxLength;
    }
}
