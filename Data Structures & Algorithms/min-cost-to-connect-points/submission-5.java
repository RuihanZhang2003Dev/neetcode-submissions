class Solution {
    public int minCostConnectPoints(int[][] points) {
        /*
        idea: while kruskal works here, prim has better efficiency here since kruskal would require 
        creating all possible edge here from points to points and have to create the min heap out of it
        the total cost is O(n^2logn). For prims, you start at the point indexing 0, and at each point,
        compute the distance between the current node and the unvisited nodes. and find the node which 
        has the minimum distance from the current node. include that edge and move to that node as next
        node
        */
        int len = points.length;
        boolean[] visited = new boolean[len];
        int[] costs = new int[len];
        Arrays.fill(costs, Integer.MAX_VALUE);
        // mark the first node as visited
        visited[0] = true;
        int num_edges = 0;
        int minCost = 0;
        int curPoint = 0;

        while (num_edges < len -1) {
            int next = -1;  // next is the closest point from current point
            for (int i = 0; i< len; i++) {
                if (visited[i]) continue;
                int cost = Math.abs(points[curPoint][0] - points[i][0]) + 
                Math.abs(points[curPoint][1] - points[i][1]);
                // find the closest unvisited point
                // if current point has a closer distance to the current unvisited point than 
                // its previous point, then update distance
                costs[i] = Math.min(costs[i], cost);    
                // if the distance between the current point to the current unvisited point is 
                // closer than the distance betweent the current point and its closest point,
                // update the closest point.
                if (next == -1 || costs[i] < costs[next]) {
                    next = i;
                }
            }

            // after finding the closest unvisited point, increase mincost, update curpoint 
            // and include edge
            visited[next] = true;
            curPoint = next;
            minCost += costs[next];
            num_edges += 1;
        }
        return minCost;
    }
}
