class Solution{
    public int[][] kClosest(int[][] points, int k) {
        /*
        idea: use minheap with priority queue, use the distance of the coordinate as element
        in the queue, create an object point that records the coordinates and the distance
        */

        PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        int[][] result = new int[k][2];

        for (int[] point: points) {
            int x = point[0];
            int y = point[1];
            int distance = distance(x, y);
            Point p = new Point(x, y, distance);
            pq.add(p);
        }

        // now the heap is built and the map is created, extract k many points
        for (int j = 0; j < k; j++) {
            Point p= pq.poll();
            int[] coord = {p.x, p.y};
            result[j] = coord;
        }

        return result;

    }

    // helper to get distance
    private int distance(int x, int y) {
        return x*x + y*y; // no need to get square root involved, since we do not need further
        // computation
    }

    class Point {
        int x;
        int y;
        int distance;

        public Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}
