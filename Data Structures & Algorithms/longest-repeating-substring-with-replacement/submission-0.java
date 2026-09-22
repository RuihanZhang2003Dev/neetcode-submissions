class Solution {
    public int characterReplacement(String s, int k) {
        /*
        idea: use sliding window, use an array to keep track of the frequency of letters, 
        find the most frequent letter inside the window, size of window - frequency of 
        most frequent letters <= k since that means we can have at most k replacements
        inside the window and still make it work
        */
        int[] freq = new int[26];
        int l = 0;
        int r = 0;
        int maxLength = 0;
        int mostFreq = 0;
        while (r < s.length()){
            freq[s.charAt(r) - 'A']++;
            mostFreq = Math.max(getMostFreq(freq), mostFreq);
            if ((r-l+1 - mostFreq) <= k){
                maxLength= Math.max(maxLength, r-l +1);
                r++;
            }
            else {
                while ((r-l+1 - mostFreq > k)){
                    freq[s.charAt(l) - 'A']--;
                    l++;
                }  
                mostFreq = getMostFreq(freq);
                r++;
            }
        }


        return maxLength;
    }

    public static int getMostFreq(int[] freq){
        int max =0;
        for (int i = 0; i< freq.length; i++){
            max = Math.max(max, freq[i]);
        }
        return max;
    }
}
