class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        /*
        idea: build the adj list first, then we use dijkstra to find the minimum spanning tree, no need
        to find the path hence no need to keep track of the previous node, since we want the a time, we
        would expand level by level
        */
        int[] dists = new int[n+1];
        Arrays.fill(dists, Integer.MAX_VALUE);
        dists[k] =0;

        // build adjcency list
        List<int[]>[] adj  = new ArrayList[n+1];
        for (int i= 0; i < adj.length; i++) adj[i] = new ArrayList<>();
        for (int[] time: times) {
            int source = time[0];
            int target = time[1];
            int time_needed = time[2];
            adj[source].add(new int[]{target, time_needed});
        }

        PriorityQueue<int[]> toCheck = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        toCheck.offer(new int[]{k, 0});
        // poll in level so keep a counter
        while (!toCheck.isEmpty()) {   
            int[] cur = toCheck.poll();
            int curNode = cur[0];
            int curDist = cur[1];
            if (curDist > dists[curNode]) continue;

            // check each neighbor, if it improves the distance be going from current node, then 
            // update
            for (int[] nei: adj[curNode]) {
                int to = nei[0];
                int to_dist = curDist + nei[1];
                if (to_dist < dists[to]) {
                    dists[to] = to_dist;
                    toCheck.offer(new int[]{to, to_dist});
                }  
            }
        }
        int time = -1;
        for (int i = 1; i< dists.length; i++) {
            if (dists[i] == Integer.MAX_VALUE) return -1;
            time = Math.max(time, dists[i]);
        }
        return time;
    }
}
