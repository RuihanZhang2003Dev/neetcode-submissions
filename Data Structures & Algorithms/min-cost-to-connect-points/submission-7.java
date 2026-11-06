class Solution {
    public int minCostConnectPoints(int[][] points) {
        /*
        idea: use prim's to solve this issue. go through all unvisited points, mark them as visited,
        find the closest point while keepin track of the shortest distance of all points to another 
        point. Since we are making a MST, we would have n -1 edge
        */

        int len = points.length;
        boolean[] visited = new boolean[len];
        int[] dists = new int[len];
        Arrays.fill(dists, Integer.MAX_VALUE);
        int curPoint = 0;
        visited[curPoint] = true;
        int edge_count = 0;
        int minCost = 0;

        while (edge_count < len -1) {
            int next = -1;  // this is the next point we are going to visit
            for (int i = 0; i < len; i++) {
                if (visited[i]) continue;
                int dist = Math.abs(points[curPoint][0] - points[i][0]) + 
                Math.abs(points[curPoint][1] - points[i][1]);
                dists[i] = Math.min(dist, dists[i]);    // if the distance from current point to the 
                // current unvisited point is smaller, then update dist[i]
                if (next == -1 || dists[i] < dists[next]) next = i;
            }
            visited[next] = true;   // include the shortest edge in the MST
            minCost += dists[next];  // increase total minCost
            edge_count++;   // increase edge count
            curPoint = next;    // update current point
        }
        return minCost;
    }
}





