class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        /*
        idea: build the adj list, then we start removing leaves node, and decreasing the 
        neighbor's neighbor count by 1, and if the neighbor count for the current node
        is 1, we put it into the queue
        */ 
        if (edges.length == 0) return List.of(0);
        if (edges.length == 1) return List.of(0,1);
        List<Integer>[] adj = new ArrayList[n];
        for (int i= 0; i< n; i++) {
            adj[i] = new ArrayList<>();
        }
        int[] nei_count = new int[n];
        for (int[] edge: edges) {
            int n1 = edge[0];
            int n2 = edge[1];
            adj[n1].add(n2);
            adj[n2].add(n1);
            nei_count[n1]++;
            nei_count[n2]++;
        }

        // start by enqueuing the leaves
        Queue<Integer> toRemove = new LinkedList<>();
        for (int i =0; i< n; i++) {
            if (nei_count[i] == 1) {
                toRemove.offer(i);
            }
        }
        int vertices_count = n;
        boolean[] removed = new boolean[n];
        while (!toRemove.isEmpty()) {
            if (vertices_count <= 2) break;
            // remove all leave nodes before rechecking size
            else {
                int size = toRemove.size();
                for (int i= 0; i< size; i++) {
                    int curLeaf = toRemove.poll();
                    for (int nei: adj[curLeaf]) {
                        if(!removed[nei]) {
                            nei_count[nei]--;
                            // if by removing one becomes the leaf
                            if (nei_count[nei] == 1) {
                                toRemove.offer(nei);
                            }
                            removed[curLeaf] = true;
                        } 
                    }
                    vertices_count--;
                }  
            }
            
        }
        
        List<Integer> res= new ArrayList<>();
        for (int i =0 ; i< n; i++) {
            if (!removed[i]) {
                res.add(i);
            }
        }
        return res;
    }
}