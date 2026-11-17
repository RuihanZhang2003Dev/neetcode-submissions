class Solution {
    List<Integer>[] adj;
    boolean[] visited;
    public int countComponents(int n, int[][] edges) {
        /*
        idea: we can construct an adjacency list and go through all nodes, at each unvisited nodes,
        visit the whole compoenent and increase the count, until all nodes are visited
        */
        adj = new ArrayList[n];
        visited = new boolean[n];

        // build adjacency list
        for (int i =0; i< n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge: edges) {
            // bidirection since not graph not directional
            int from = edge[0];
            int to = edge[1];
            adj[from].add(to);
            adj[to].add(from);
        }
        int count = 0;
        for (int i = 0; i< n; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }
        return count;
    }

    // private helper for dfs
    private void dfs(int cur) {
        // mark cur as visited, and visit all its unvisited neighbors
        visited[cur] = true;
        for (int nei: adj[cur]) {
            if (!visited[nei]) dfs(nei);
        }
    }
}
