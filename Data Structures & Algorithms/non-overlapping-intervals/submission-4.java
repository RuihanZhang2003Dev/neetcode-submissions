class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        /*
        idea: we want to remove the minimum number of intervals so that we can make all intervals 
        non-overlapping, hence instead of sorting all intervals by start time like we did for merge
        intervals and insert interval, we will sort all intervals by end time. This way we will have 
        the earliest end time at the first position, that will always be the earliest end time and
        that will be the interval that will allow the maximum number of intervals after it (since it
        give the maximum amount of time left). Then we check if the current interval overlaps with
        the prev end time, if so, discard it. if not, update the end time to the current end time,
        since ordered intervals by end time, we can garantee that the first non overlapping interval
        found with current end time is the interval that ends the earliest.
        */

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int earliest_end = intervals[0][1];
        int removed = 0;

        for (int i = 1; i< intervals.length; i++) {
            int[] cur = intervals[i];
            // if cur starts before the previous ends, remove
            if (cur[0] < earliest_end) removed++;
            // if not, update earliest end
            else earliest_end = cur[1];
        }

        return removed;
    }
}
