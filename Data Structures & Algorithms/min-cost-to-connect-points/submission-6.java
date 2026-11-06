class Solution {
    public int minCostConnectPoints(int[][] points) {
        /*
        idea: while kruskal works here, prim has better efficiency here since kruskal would require 
        creating all possible edge here from points to points and have to create the min heap out of it
        the total cost is O(n^2logn). For prims, you start at the point indexing 0, and at each point,
        compute the distance between the current node and the unvisited nodes. and find the node which 
        has the minimum distance from the current node. include that edge and move to that node as next
        node. Now the efficiency is O(n^2)
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
                // the objective of the cost[i] is that when we have iterated through all points,
                // if the last point's closest point is the first point, you cannot iterate through
                // to calculate the distance as the first point is already marked as visited.
                // however, when we compute first point, we have already calculated the distance 
                // between the last point and the first point as it goes through all unvisited nodes
                // so at the last iteration, when there is no non visited points, we still have the
                // distance(edge) recorded in the array. What I initially did was to calculate all
                // distances between current point and all the unvisited points and find the closest
                // point without recording its distance with all other points, while other unvisitied 
                // points can have the current point as closest point. Consequently, at 
                // the last point, we will not be able to find the closest point to it.
                // as there is no recording of closest distance between it and another point, even
                // though they were calculated previously.
                costs[i] = Math.min(costs[i], cost);    
                // if the distance between the current point to the current unvisited point is 
                // closer than the distance betweent the current point and its closest point in record,
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
