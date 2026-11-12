class Solution {
    public String reorganizeString(String s) {
        // idea: use a maxheap for frequency, we will construct a string prioritizing the currently
        // most frequent character
        PriorityQueue<int[]> occur = new PriorityQueue<>((a, b) -> b[1] -a[1]);
        int[] freq = new int[26];
        for (int i = 0;i < s.length(); i++) {
            freq[s.charAt(i) -'a']++;
        }
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) occur.offer(new int[]{i, freq[i]});
        }
        
        StringBuilder sb = new StringBuilder();
        int[] lastUsed = {0, 0};
        while (!occur.isEmpty()) {
            int[] mostFreq = occur.poll();
            char c = (char) ('a' + mostFreq[0]);
            int curFreq = mostFreq[1];
            sb.append(c);
            curFreq--;
            if (lastUsed[1] > 0) occur.offer(lastUsed);
            lastUsed = new int[]{mostFreq[0], curFreq};
        }
        if (lastUsed[1] > 0) return ""; // if they did not use all the characters, then we cannot form
        // a new string
        return sb.toString();

    }
    
    
    
    
    
    
    
    
    
    
}