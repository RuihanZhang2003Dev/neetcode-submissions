class Solution {
    public boolean validTree(int n, int[][] edges) {
        /*
        idea: we can use union find, if at the end of the unions, they do not have the same parent, 
        that means they are in different set, then return false, if they have the same parent, 
        return true.
        */
        if (edges.length != n-1) return false;
        int[] parents = new int[n];
        int[] sizes = new int[n];
        // initialize
        for (int i = 0; i< parents.length; i++) {
            sizes[i] =1;
            parents[i] =i;
        }

        for (int[] edge: edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            if (find(parents, node1) == find(parents, node2)) return false; 
            // if they were already in the same
            // set without this edge, then by adding this edge forms a cycle
            union(parents, sizes, node1, node2);
        }
        return true;
    }

    private int find(int[] parents, int x) {
        if (parents[x] != x) {
            parents[x] = find(parents, parents[x]);
        }
        return parents[x];
    }  

    private void union(int[] parents, int[] sizes, int x, int y) {
        int parentx = find(parents, x);
        int parenty = find(parents, y);

        // smaller component merges into larger component
        if (sizes[parentx] > sizes[parenty]) {
            sizes[parentx] += sizes[parenty];
            parents[parenty] = parentx;
        }
        else {
            sizes[parenty] += sizes[parentx];
            parents[parentx] = parenty;
        }
    }
}











