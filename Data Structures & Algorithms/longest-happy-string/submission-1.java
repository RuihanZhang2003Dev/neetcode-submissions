class Solution {
    public String longestDiverseString(int a, int b, int c) {
        /*
        idea: use a max heap to get the most recurring letter and check if it is used twice, if it 
        is, use the second most recurring letter, if there is not any, return the current string, 
        since we cannot build it further. if it is not used twice, then we will append it and put
        it back to heap with reduced frequency
        */
        PriorityQueue<int[]> freq = new PriorityQueue<>((f, s) -> Integer.compare(s[1], f[1]));
        if (a> 0) freq.offer(new int[]{0, a});
        if (b> 0) freq.offer(new int[]{1, b});
        if (c> 0) freq.offer(new int[]{2, c});

        StringBuilder res = new StringBuilder();
        int strLen = 0;
        while (!freq.isEmpty()) {
            int[] cur = freq.poll();
            char curC = (char) ('a' + cur[0]);

            // check if used twice
            if (strLen> 0 && curC == res.charAt(strLen -1)) {
                // if used twice, use the second most
                if (strLen> 1 && curC == res.charAt(strLen -2)) {
                    if (freq.isEmpty()) return res.toString();
                    else {
                        int[] cur2 = freq.poll();
                        res.append((char) ('a' + cur2[0]));
                        cur2[1]--;
                        if (cur2[1] > 0) freq.offer(cur2);
                    }
                }
                // if only used once, add it again
                else {
                    res.append(curC);
                    cur[1]--;
                }
            }
            // if not even used once
            else {
                res.append(curC);
                cur[1]--;
            }
            strLen++;
            if (cur[1] > 0) freq.offer(cur);
        }
        return res.toString();

    }
}


