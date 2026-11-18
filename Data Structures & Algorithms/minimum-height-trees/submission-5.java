class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        /*
        idea: build the adjacency lists, and count the number of neighbors, then use bfs to 
        remove leave node and check if by removing the leaf node, the neighbors becomes a
        leaf node, if so, put it into the queue again, until there are 2 or less nodes left.
        when we remove leaves, we will remove them all together, we will not stop mid removal
        */
        if (n == 1) return List.of(0);
        if (n == 2) return List.of(0,1);
        List<Integer>[] adj = new ArrayList[n];
        int[] nei_count= new int[n];
        for (int i = 0; i< n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge: edges) {
            int from = edge[0];
            int to = edge[1];
            adj[from].add(to);
            adj[to].add(from);
            nei_count[from]++;
            nei_count[to]++;
        }

        Queue<Integer> toRemove = new LinkedList<>();
        int vertices_count = n;
        for (int i= 0; i< n; i++) {
            if (nei_count[i] == 1) toRemove.offer(i);
        }
        while (!toRemove.isEmpty() && vertices_count > 2) {
            // remove level by level
            int size = toRemove.size();
            for (int i =0; i< size; i++) {
                int cur = toRemove.poll();
                vertices_count--;
                for (int nei: adj[cur]) {
                    nei_count[nei]--;
                    if (nei_count[nei] == 1) toRemove.offer(nei);
                }
            }
        }
        return new ArrayList<>(toRemove);
    }
}