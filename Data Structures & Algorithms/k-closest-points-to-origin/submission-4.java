class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // use min heap, closest
        PriorityQueue<Distance> dists = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        // build
        for (int[] point : points) {
            dists.offer(new Distance(point[0], point[1]));
        }
        int[][] res = new int[k][2];
        for (int i = 0; i< k; i++) {
            Distance d = dists.poll();
            res[i][0] = d.x;
            res[i][1] = d.y;
        }
        return res;
    }

    class Distance {
        int x;
        int y; 
        int distance;

        public Distance(int x, int y) {
            this.x = x;
            this.y = y;
            distance = x*x + y*y;   // since we are simply compare distance and not doing anything 
            // to distance for later, we do not need sqrt
        }
    }
}
