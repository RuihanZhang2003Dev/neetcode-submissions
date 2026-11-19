class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        /*
        idea: use bellman ford, build adjacency list and in level bfs, record what the current airport
        can reach and if the distance is shorter if we leave from this airport, if so, then update
        shortest distance
        */

        List<int[]>[] adj = new ArrayList[n];
        int[] minDists = new int[n];
        for (int i =0 ; i< n; i++) {
            adj[i] = new ArrayList<>();
            minDists[i] = Integer.MAX_VALUE;
        }
        minDists[src] = 0;
        for (int[] flight: flights) {
            int from = flight[0];
            int to = flight[1];
            int dist = flight[2];
            adj[from].add(new int[]{to, dist});
        }

        Queue<int[]> dists = new LinkedList<>();
        dists.offer(new int[]{src, 0});
        for (int i =0; i<= k; i++) {
            int size = dists.size();
            for (int j= 0; j< size; j++) {
                int[] cur = dists.poll();
                int from = cur[0];
                int dist = cur[1];
                for (int[] nei: adj[from]) {
                    int to = nei[0];
                    int price = nei[1];
                    if (minDists[to] > price+ dist) {
                        minDists[to] = price + dist;
                        dists.offer(new int[]{to, price+ dist});
                    }
                }
            }
        }
        if (minDists[dst] == Integer.MAX_VALUE) return -1;
        return minDists[dst];
    }
}
