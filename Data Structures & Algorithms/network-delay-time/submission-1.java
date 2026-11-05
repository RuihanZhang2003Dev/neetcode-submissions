class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        /*
        idea: use dijkstras, make the graph with nodes 1 -n, and connect edges with adjacency list,
        make a table with one column that stores the minimum distance between the departure node (k)
        and the current node. and another column that stores the previous node in this shortest path.
        itrate through adjacency list, when the distance calculated is smaller than the current shortest
        distance, update it and enqueue the current node with the updated distance
        */

        int[] shortestTimes = new int[n+1];
        int[] prevNodes = new int[n+1];

        Arrays.fill(shortestTimes, Integer.MAX_VALUE);
        shortestTimes[k] = 0;

        // initialize graph with adjacency lists
        List<List<int[]>> adj_list = new ArrayList<>();  // here int[] stores{node, distance} pair
        for (int i = 0; i < n+1; i++) adj_list.add(new ArrayList<>());
        for (int[] time: times) {
            int from = time[0];
            int to = time[1];
            int t = time[2];

            adj_list.get(from).add(new int[]{to, t});
        }

        // initialize priority queue
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.offer(new int[]{k, 0});

        // iterate through adjacency list
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curNode = cur[0];
            int time = cur[1];

            for (int[] neighbor: adj_list.get(curNode)) {
                int nei_node = neighbor[0];
                int nei_time = neighbor[1];
                int shortest_time_to_nei = shortestTimes[nei_node];

                int new_time = time + nei_time;
                // if we update the shortest time, then we have to enqueue the neighbor to see if 
                // the its neighbor requires update
                if (new_time < shortest_time_to_nei) {
                    shortestTimes[nei_node] = new_time;
                    prevNodes[nei_node] = curNode;
                    queue.add(new int[]{nei_node, new_time});
                }
            }
        }
        // after constructing the graph and iterating through all nodes reachable from k, if there is 
        // a node that is unreachable, its shortest distance will remain max value
        // find the max time from the min distances other wise, since we want to reach all the nodes
        // the time will be the minimum time taken for k to reach the furthest node
        int minTime = 0;
        for (int i = 1; i< shortestTimes.length; i++) {
            if (shortestTimes[i] == Integer.MAX_VALUE) return -1;
            minTime = Math.max(minTime, shortestTimes[i]);
        }
        return minTime;
    }
}
