class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        /*
        idea: create a min heap to store departure and the capacity required, keep track of the 
        current capacity, if the capacity cannot hold return false; if we went through, return true
        and create a min heap for arrival and the capacity freed
        */ 
        
        PriorityQueue<int[]> required = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> freed = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        
        for (int[] trip: trips) {
            required.offer(new int[]{trip[1], trip[0]});
            freed.offer(new int[]{trip[2], trip[0]});
        }
        int curCap = capacity;
        int time = 0;
        while (!required.isEmpty()) {
            while (!freed.isEmpty() && time == freed.peek()[0]) {
                int[] end = freed.poll();
                curCap += end[1];
            }
            // if we meet a start of a station
            while (!required.isEmpty() && time == required.peek()[0]) {
                int[] begin = required.poll();
                curCap -= begin[1];
            }
            if (curCap < 0) return false;
            if (required.isEmpty()) time = freed.peek()[0];
            else time = Math.min(required.peek()[0], freed.peek()[0]);
        }
        return true;
    }
}