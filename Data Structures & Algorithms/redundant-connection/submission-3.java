class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        /*
        idea: union find for cycle detection, if during union there is a cycle(both edge has the same 
        parent), return that edge
        */
        // since we initially have n-1 edge and now we have 1 extra, that means we have n edge, same
        // number as the number of nodes
        int len = edges.length+1;
        int[] parent = new int[len];
        int[] sizes = new int[len];
        for (int i =0; i< len; i++) {
            parent[i] = i;
            sizes[i] = 1;
        }

        for (int[] edge: edges) {
            int from = edge[0];
            int to = edge[1];
            if (find(parent, from) == find(parent, to)) return edge;
            union(parent, sizes, from, to);
        }
        return new int[]{};
    }

    public int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    public void union(int[] parent, int[] sizes, int x, int y) {
        int parentx = find(parent, x);
        int parenty = find(parent, y);

        // merge the smaller component to the larger one
        if (sizes[parentx] > sizes[parenty]) {
            sizes[parentx] += sizes[parenty];
            parent[parenty] = parentx;
        }
        else {
            sizes[parenty] += sizes[parentx];
            parent[parentx] = parenty;
        }
    }   
}
