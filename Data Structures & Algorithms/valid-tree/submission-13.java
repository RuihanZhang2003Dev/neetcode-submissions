class Solution {
    List<List<Integer>> nodes = new ArrayList<>();
    boolean[] visited;
    int count = 0;
    public boolean validTree(int n, int[][] edges) {
        /*
        idea: this is not khan, check first example: if we convert the undirected graph into 
        directed graph and then add [2, 4], there will be no cycle detection since 0 -> 1 -> 4
        and 0 -> 2 -> 4 is not a cycle.A valid tree has exactly n − 1 edges and is connected. 
        Check the edge count first. Then DFS from node 0 (edges go both ways) and count how many 
        nodes we reach. If it’s n, it’s connected, and with n − 1 edges, that means no cycles.
        */

        if (edges.length != n -1) return false;
        // build the adjacency list
        for (int i = 0; i< n; i++) nodes.add(i, new ArrayList<>());

        for (int[] edge: edges) {
            nodes.get(edge[0]).add(edge[1]);
            nodes.get(edge[1]).add(edge[0]);    // since undirected, we count both direction
        }
        
        // now run dfs
        visited = new boolean[n]; // since it is not directed, it does not matter where you    
        // start if every nodes are connected, you will eventually visit all nodes with 1 
        // iteration that is why we only run visit once
        visit(0);
        return count == n;
    }

    private void visit(int node) {
        visited[node] = true;   // mark it so the node is not revisited
        count++;    // increase count
        
        for (int neighbor: nodes.get(node)) {
            if (!visited[neighbor]) visit(neighbor);
        }
        return ;
    }
}
