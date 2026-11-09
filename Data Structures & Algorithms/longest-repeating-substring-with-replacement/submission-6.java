class Solution {
    public int characterReplacement(String s, int k) {
        /*
        idea: use sliding window, as long as in the sliding window, the length of sliding window -
        the most frequent character <= k, we are good, since that means we can perform k replacement
        to replace the rest of the characters to the most frequent characters to get the substring
        that contains only 1 distinct character.
        every time we expand the window, check if by including current char we have a new most 
        frequent character, if we do then update the largest frequency. If by expanding the window,
        there are more than k char that would need to change, shrink left until it is no longer the
        case
        */
        HashMap<Character, Integer> freq = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxWindow = 0;
        int mostFreq= 0;
        
        while (right < s.length()){
            // expand the window, update the frequency map, update the most frequent if needed.
            // if window violates the condition, shrink and find the most frequent char again
            // until the rule is no longer broken. update the maxWindow if cur window has a larger
            // length
            char c = s.charAt(right);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
            mostFreq = Math.max(mostFreq, freq.get(c)); // if current char becomes the most frequent
            while ((right - left + 1 - mostFreq) > k) {
                // if there are more than alphabet to change, shrink the window from left
                char leftC = s.charAt(left);
                freq.put(leftC, freq.get(leftC)-1);
                left++;
            }
            maxWindow = Math.max(right -left +1, maxWindow);
            right++;
        }
        return maxWindow;
    }
}
