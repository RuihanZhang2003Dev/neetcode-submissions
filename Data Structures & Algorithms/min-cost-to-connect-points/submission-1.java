class Solution {
    public int minCostConnectPoints(int[][] points) {
        /*
        idea: we have to use minimum spanning tree. I will use kruskal's. I will first find all the 
        edges, put them in a min heap where the edge length will be the deciding factor, each edge will
        contain: the index of from and to points in points, and the distance between them. Then I will
        start building the MST with minheap while using union find for cycle detection. For union find, 
        I will need 2 arrays: 1 for parent and 1 for size for union with size
        */
        
        // find all edges and put them in a minHeap
        PriorityQueue<int[]> minEdges = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        for (int i = 0; i< points.length; i++) {
            for (int j = i +1; j < points.length; j++) {
                int[] edge = new int[3];
                edge[0] = i;
                edge[1] = j;
                edge[2] = Math.abs((points[i][0] - points[j][0])) + 
                Math.abs((points[i][1] - points[j][1]));
                minEdges.offer(edge);
            }
        }

        // build the MST with minHeap, while building it, also build distjoint sets
        int[] parent = new int[points.length];
        int[] size = new int[points.length];
        Arrays.fill(size, 1);
        for (int i = 0; i< parent.length; i++) {
            parent[i] = i;
        }

        int minCost = 0;
        while (!minEdges.isEmpty()) {
            int[] minEdge = minEdges.poll();
            int from = minEdge[0];
            int to = minEdge[1];
            int dist = minEdge[2];
            
            // check if by adding current edge in mst, it would form a cycle. meaning if the two
            // vertices already are within the same component. (having same parent in union find)
            if (find(parent, from) == find(parent, to)) continue;

            // if not, then add current min edge to the subgraph(mst)
            minCost += dist;
            union(parent, size, from, to);
        }

        return minCost;
    }


    // private helper for union find
    public int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    public void union(int[] parent, int[] size, int x, int y) {
        int parentx = find(parent, x);
        int parenty = find(parent, y);

        if (size[parentx] > size[parenty]) {
            parent[parenty] = parentx;
            size[parentx] += size[parenty];
        }
        else {
            parent[parentx] = parenty;
            size[parenty] += size[parentx];
        }  
    }
}
