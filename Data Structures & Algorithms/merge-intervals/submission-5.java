class Solution {
    public int[][] merge(int[][] intervals) {
        /*
        idea: use a prev_start and prev_int to keep track of the merged interval, if the current one
        overlaps, merge them without adding it to the result
        */
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();
        int prev_start= intervals[0][0];
        int prev_end = intervals[0][1];
        
        for (int i =1; i< intervals.length; i++) {
            int[] cur = intervals[i];
            
            if (cur[0]<= prev_end) {
                prev_end = Math.max(prev_end, cur[1]);
            }
            else {
                res.add(new int[]{prev_start, prev_end});
                prev_start = cur[0];
                prev_end = cur[1];
            }
        }

        res.add(new int[]{prev_start, prev_end});
        return res.toArray(new int[res.size()][]);
    }
}
