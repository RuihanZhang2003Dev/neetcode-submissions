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
        idea: sort the intervals from start time, and check if they overlap
        */
        if (intervals.size() < 2) return true;
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));
        for (int i = 1; i< intervals.size(); i++) {
            if (intervals.get(i).start < intervals.get(i -1).end) return false;
        }
        return true;
    }
}
