/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        /*
        idea: sort the interval by start time and check if the current one overlaps with the previous
        interval.
        */
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        Interval prev = null;

        for (Interval inter: intervals) {
            if (prev != null && inter.start < prev.end) return false;
            prev = inter; 
        }
        return true;
    }
}
