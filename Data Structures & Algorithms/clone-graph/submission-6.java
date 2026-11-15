/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        /*
        idea: use an hashset check if the current node already has a copy, then use the old node's 
        connection to connect the nodes
        */
        if (node == null) return null;
        Map<Node, Node> nodes = new HashMap<>();
        Queue<Node> queue = new LinkedList<>(); 
        nodes.put(node, new Node(node.val));
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            // go through original adjacency list, if the current neighbor is not constructed, make
            // the copy and enqueue original one to go through its adjacency list
            Node copy = nodes.get(cur);
            for (Node nei: cur.neighbors) {
                if (!nodes.containsKey(nei)) {
                    nodes.put(nei, new Node(nei.val));
                    queue.offer(nei);
                }
                copy.neighbors.add(nodes.get(nei));
            }
            

        }
        return nodes.get(node);

    }
}












