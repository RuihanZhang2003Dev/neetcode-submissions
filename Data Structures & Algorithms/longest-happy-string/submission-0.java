class Solution {
    public String longestDiverseString(int a, int b, int c) {
        /*
        idea: use the most frequently used string, keep count of the minimum frequency, 
        if the current string is still the most frequent after 1 use, use current string twice. if the 
        current string is already used twice, then we cannot use it no more, use the second most 
        string, if there is none, then return ""
        */

        PriorityQueue<int[]> counts = new PriorityQueue<>((f, s) -> s[1] - f[1]);
        if (a > 0) counts.offer(new int[]{0, a});
        if (b > 0) counts.offer(new int[]{1, b});
        if (c > 0) counts.offer(new int[]{2, c});

        int strLen = 0;
        StringBuilder res = new StringBuilder();
        while (!counts.isEmpty()) {
            int[] cur = counts.poll();
            char curChar = (char) ('a' + cur[0]);
            // if we used it last char
            if (strLen > 0 && curChar == res.charAt(strLen -1)) {
                // check if we used it twice already, if so, use the second one
                if (strLen > 1 && curChar == res.charAt(strLen -2)) {
                    if (counts.isEmpty()) return res.toString();
                    else {
                        int[] cur2 = counts.poll();
                        res.append((char) ('a' + cur2[0]));
                        cur2[1]--;
                        if (cur2[1] > 0) counts.offer(cur2);
                    }
                }
                // if we havent used it twice, use it
                else{
                    res.append(curChar);
                    cur[1]--;
                }
            }
            else {  
                res.append(curChar);
                cur[1]--;
            }
            strLen++;
            if (cur[1] > 0) counts.offer(cur);
        }
        return res.toString();
    }
}