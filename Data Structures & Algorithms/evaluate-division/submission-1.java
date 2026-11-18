class Pair<K,V> {
    K key;
    V value;
    public Pair(K k, V val) {
        key = k;
        value = val;
    }
    public K getKey() {
        return key;
    }
    public V getValue() {
        return value;
    }
}
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        /*
        idea: build the graph with adjacency lists and by iterating through the equations, 
        we would go from numerator to denominator. For queries, we can apply brute force, so
        on a graph, we will perfrom bfs
        */
        // use a hashmap to build adjacency list
        // map a-> list of [b, a/b] pair
        Map<String, List<Pair<String, Double>>> adj = new HashMap<>(); 

        for (int i = 0; i< equations.size(); i++) {
            List<String> cur = equations.get(i);
            String a = cur.get(0);
            String b = cur.get(1);
            adj.putIfAbsent(a, new ArrayList<>());
            adj.putIfAbsent(b, new ArrayList<>());
            adj.get(a).add(new Pair(b, values[i]));
            adj.get(b).add(new Pair(a, (1/values[i])));
        }
        double[] res = new double[queries.size()];
        int index= 0;
        for (List<String> query: queries) {
            res[index] =bfs(adj, query.get(0), query.get(1));
            index++;
        }
        return res;
    }
    
    // private bfs, bfs here for better cycle detection
    // a/b, a->b, find a path from a to b, once we got to B, the result is the product of all
    // edge's weight
    private double bfs(Map<String, List<Pair<String, Double>>> adj, String source, String target) {
        if (!adj.containsKey(source) || !adj.containsKey(target)) {
            return -1.0;
        }
        if (source.equals(target)) return 1.0;
        Queue<Pair<String, Double>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(new Pair(source, 1.0));
        visited.add(source);
        while (!queue.isEmpty()) {
            Pair<String, Double> cur =queue.poll();
            String node = cur.getKey();
            Double curProd = cur.getValue();
            if (node.equals(target)) {
                return curProd;
            }
            for (Pair<String, Double> nei: adj.get(node)) {
                if (!visited.contains(nei.getKey())) {
                    visited.add(nei.getKey());
                    queue.offer(new Pair(nei.getKey(), curProd * nei.getValue()));
                }
            }
        }
        return -1.0;
    }
}


