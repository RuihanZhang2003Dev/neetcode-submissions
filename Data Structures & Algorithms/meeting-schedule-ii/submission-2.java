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
        idea: use a priority queue to check if the current meeting starts before the earliest meeting
        ends, if so, update the interval by merging them. then put it back to the priority queue
        */

        // sort the array in starting time, so that we can get the meeting that starts the earliest
        // to see if it matches the meeting that ends the earliest, if they overlap, that means we cant
        // even assignt them the room that ends the earliest, forcing us to create another room
        if (intervals.size() == 0) return 0;
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        PriorityQueue<Integer> ends = new PriorityQueue<>();
        ends.add(intervals.get(0).end);

        for (int i = 1; i< intervals.size(); i++) {
            int earliest_end = ends.peek();
            Interval cur = intervals.get(i);
            // if even the room with earliest end cannot fit the meeting, then create new room
            if (cur.start < earliest_end) ends.add(cur.end);
            // if the room can accomodate, remove it from queue, update the end time, and requeue it
            // with the new end time, and the earliest end time will always be at the front.
            else {
                ends.poll();
                ends.offer(cur.end);
            }
        }
        return ends.size();
    }
}
