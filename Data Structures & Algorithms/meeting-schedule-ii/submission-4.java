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
    public int minMeetingRooms(List<Interval> intervals) {
        /*
        idea: use priority queue to store the end times of each meeting room we create, if the
        current earliest end time cannot accomodate to the current interval, then we create a new 
        room, if we can accomodate, then update the current earliest end time put it back to queue
        */
        if (intervals.size() == 0) return 0;
        PriorityQueue<Integer> ends = new PriorityQueue<>();
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));

        ends.offer(intervals.get(0).end);
        for (int i = 1; i< intervals.size(); i++) {
            Interval cur = intervals.get(i);
            // add a room if the earliest end time cannot accomodate
            if (cur.start < ends.peek()) ends.offer(cur.end);
            // if we can accomodate, then use the room with earliest end time and update end time
            else {
                ends.poll();
                ends.offer(cur.end);
            }
        }
        return ends.size();
    }
}
