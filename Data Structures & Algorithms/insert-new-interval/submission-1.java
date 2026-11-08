class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        /*
        idea: iterate through intervals, if the new interval happens before the current interval, add 
        the current interval in and then add the rest. if the new interval happens after the current 
        interval, add the current interval only, since we do not know if there are more intervals 
        that happen before the newInterval. Finally, if the new interval overlaps the current 
        interval, merge the curretn interval into the new interval and move onto the next interval,
        since we do not know if the next interval will overlap with this newly updated interval again
        or not.
        */

        List<int[]> inters = new ArrayList<>();

        for (int i = 0; i< intervals.length; i++) {
            // if new interval happens before the current interval, add new interval and add the rest
            if (newInterval[1] < intervals[i][0]) {
                inters.add(newInterval);
                for (int j = i; j< intervals.length; j++) {
                    inters.add(intervals[j]);
                }
                return inters.toArray(new int[inters.size()][]);
            }
            
            // if new interval happens after current interval, add current interval
            else if (newInterval[0] > intervals[i][1]) {    
                inters.add(intervals[i]);
            }
            // if the new interval overlaps with curretn interval, merge into new interval
            else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }
        // if after iterating through all intervals, the new interval is still not added, add it
        inters.add(newInterval);
        return inters.toArray(new int[inters.size()][]);
    }
}
