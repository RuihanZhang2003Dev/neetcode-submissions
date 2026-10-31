class Solution {
    List<List<Integer>> nodes = new ArrayList<>();
    boolean[] visited; 
    public int countComponents(int n, int[][] edges) {
        /*
        idea: create adjacency list, then pop one node, increase count, remove the component the
        node is in, then move onto the next component, until there is no node. use an array to
        keep track the visited nodes
        */

        // build list
        for (int i = 0; i< n; i++) nodes.add(new ArrayList<>());

        for (int[] edge: edges) {
            nodes.get(edge[0]).add(edge[1]);
            nodes.get(edge[1]).add(edge[0]);
        }

        visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }

        return count;
    }

    // helper to find all nodes that connects to the current node and mark them as visited
    private void dfs(int node) {
        // mark as visited
        visited[node] = true;
        
        // run recursive on its unvisited neighbors in the adjacency list too
        for (int neigh: nodes.get(node)) {
            if (!visited[neigh]) dfs(neigh);
        }
        return ;
    }

}
