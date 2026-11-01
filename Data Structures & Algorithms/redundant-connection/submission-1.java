class Solution {   
    

    public int[] findRedundantConnection(int[][] edges) {
        /*
        idea: from the behavior we'd know that we want to find the last edge added that makes aa
        cycle, ideally I want to build the adjacency list, and while adding edges, we can detect
        cycles, since in a undirected, connected graph with no cycle, the number of edges is 
        garanteed to be number of vertex -1, that means at each edge, we will connect the edge
        with a new node, hence when there is an edge that connects to the 2 vertices that 
        already were connected (so when the number of edges == number of vertices in the graph)
        then we know that that edge is the latest adge added that makes cycle.
        
        That was the wrong solution, since if we have 2 separated components, if one has a cycle 
        and the other one does not, we will have vertex -1 node as well, it will not be check
        
        new Solution: since we have n nodes and initially n-1 edges, and then we added an edge 
        to make a cycle, we can say that we have n edge. we will DSU to solve this problem.
        first we will create nodes that are parents to themselves, then we will join them 
        together as a set. at each edge addition, we will check if the two ends of that edge
        are in the same group (so same parent), if so, then return the edge
        */

        // initialize disjoint sets(they are all parents of themselves)
        int[] parents = new int[edges.length +1];   // n+1 since nodes are labelled 1 to n
        int[] sizes = new int[edges.length +1];
        
        
        for (int i =1; i< parents.length; i++) {
            parents[i] = i;
            sizes[i] = 1;
        }

        for (int[] edge: edges) {
            int x = edge[0];
            int y = edge[1];

            // if they are already in the same set, return the current edge since they are
            // already connected through the same parent
            if (find(parents, x) == find(parents, y)) return edge;
            else 
                union(parents, sizes, x, y);
        }

        return new int[]{};
    }

    private static void union(int[] parents, int[] sizes, int x, int y){
        // update parents and update sizes
        int parentx = find(parents, x);
        int parenty = find(parents, y);

        // smaller set joins larger set, update sizes
        if (sizes[parentx] > sizes[parenty]) {
            int finalSize = sizes[parentx] + sizes[parenty];
            parents[parenty] = parents[parentx];
            sizes[parentx] = finalSize;
        }
        else {
            int finalSize = sizes[parentx] + sizes[parenty];
            parents[parentx] = parents[parenty];
            sizes[parenty] = finalSize;
        }
    }



    private static int find(int[] parents, int x) {
        // path compression, end up having same representative
        if (parents[x] != x) {
            parents[x] = find(parents, parents[x]);
        }
        return parents[x];
    }

}
