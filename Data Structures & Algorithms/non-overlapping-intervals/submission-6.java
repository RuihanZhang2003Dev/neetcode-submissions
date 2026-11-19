class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        /*
        idea: sort by end time to get intervals with earliest end time (intervals that allows others to
        have the maximum time space), then start iterating through it, if the interval starts before 
        the earliest end time, then we remove it, if not, update the earliest end time
        */
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int earliest_end = intervals[0][1];
        int removed = 0;
        for (int i = 1; i< intervals.length; i++) {
            int[] cur = intervals[i];
            if (cur[0] < earliest_end) removed++;
            else earliest_end = cur[1];
        
        }
        return removed;
    }
}
