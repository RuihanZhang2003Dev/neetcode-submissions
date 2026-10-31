class Solution {
    List<List<Integer>> nodes = new ArrayList<>();
    boolean[] visited;
    int count;
    public boolean validTree(int n, int[][] edges) {
        /*
        idea: this is not khan, check first example: if we convert the undirected graph into 
        directed graph and then add [2, 4], there will be no cycle detection since 0 -> 1 -> 4
        and 0 -> 2 -> 4 is not a cycle. we iterate through the nodes, use an array to store
        if it is visited or not. Keep count of the number of node visited. At the end of the 
        iteration, we visited all nodes(so n number) while have n -1 edges, then we have a tree
        for a graph to be a valid tree we need: 1. all nodes are connected (i can get from one 
        node to another) 2. there is not cycle
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
