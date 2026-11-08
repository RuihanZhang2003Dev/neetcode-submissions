class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        /*
        idea: since the intervals are said to be non-overlapping and in order, then all we have to do
        is to find where to insert the new interval, if the new interval overlaps with the intervals
        in the original array, then we merge until we cannot merge any more, then we add it to the 
        array
        */
        List<int[]> inters = new ArrayList<>();
        for (int i = 0; i< intervals.length; i++) {
            // if new interval ends before the current one, add the rest of the list
            if (newInterval[1] < intervals[i][0]) {
                inters.add(newInterval);
                for (int j = i; j< intervals.length; j++) {
                    inters.add(intervals[j]);
                }
                return inters.toArray(new int[inters.size()][]); 
            }
            // if the new interval starts after the current one ends, then add current one and go for
            // the next iteration, since the new interval can still overlap with future intervals
            else if (newInterval[0] > intervals[i][1]) {
                inters.add(intervals[i]);
            }
            
            // if the new overlaps with the current interval, update the new interval by merging with
            // current interval and to next iteration
            else {
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            } 
        }  
        // in case it was never added in the array
        inters.add(newInterval);
        return inters.toArray(new int[inters.size()][]); 
    }
}
