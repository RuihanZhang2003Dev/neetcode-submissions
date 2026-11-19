class Solution {
    public int minCostConnectPoints(int[][] points) {
        /*
        idea: use prim's, at each point, we calculate its distance with all other points, if the 
        current point does have a shorter distance with another point than the distance recorded
        then record the shorter distance, and also keep in mind the closest point, so that we can
        move to it after
        */

        int len= points.length;
        int[] dists = new int[len];
        Arrays.fill(dists, Integer.MAX_VALUE);
        boolean[] visited = new boolean[len];
        dists[0] = 0;
        visited[0] = true;
        int curPoint =0;
        int minCost = 0;
        int edge_count = 0;

        while (edge_count < len -1) {
            int next = -1;
            // iterate through all unvisited nodes
            for (int i = 0; i< points.length; i++) {
                if (visited[i]) continue;
                int dist = Math.abs(points[curPoint][0] - points[i][0]) +
                Math.abs(points[curPoint][1] - points[i][1]);
                dists[i] = Math.min(dist, dists[i]);
                if (next == -1 || dists[i] < dists[next]) next = i;
            }
            curPoint = next;
            minCost += dists[next];
            visited[next] = true;
            edge_count++;
        }
        return minCost;
    }
}
