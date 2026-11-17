class Solution {
    List<Integer>[] adj;
    boolean[] visited;
    public int countComponents(int n, int[][] edges) {
        /*
        idea: construct adjacency list, and then go through unvisited nodes, then visited all nodes 
        within the same component and then move onto the next unvisited node(that unvisited node is
        garanteed to be not connected to the component we just visited), dfs
        */
        adj = new ArrayList[n];
        visited = new boolean[n];
        // build adj
        for (int i = 0; i< n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge: edges) {
            int from = edge[0];
            int to = edge[1];

            adj[from].add(to);
            adj[to].add(from);  // bidirectional since edges do not have directions
        }

        
        int count =0;
        for (int i = 0; i< n; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
            
        }   
        return count;
    }

    // private helper for dfs, find all components connected to the node
    private void dfs(int node) {
        visited[node] = true;
        for (int nei: adj[node]) {
            if (!visited[nei]) dfs(nei);
        }
    }
}
