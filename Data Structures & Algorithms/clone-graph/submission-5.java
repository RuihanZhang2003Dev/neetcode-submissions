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
        idea: create a hashmap of index node pair, then link them through neighbors, the        
        neighbors will have the original node, if its copy node already exists in the hashMap
        (node with same index), then we add that copied node into the neighbors list, no need
        to create new node. Use dfs, treat the current node and then add new nodes
        */

        if (node == null) return null;
        HashMap<Integer, Node> copiedNodes = new HashMap<>();
        return copyNodes(node, copiedNodes);
    }

    // helper to treat each nodes 
    private Node copyNodes(Node node, HashMap<Integer, Node> copiedNodes){
        // so the idea is to create a copy of the current node, then create the copy of its
        // neighbors by running copyNodes again, if the node is already copied, no need to
        // copy it again

        if (copiedNodes.containsKey(node.val)) return copiedNodes.get(node.val);
        Node cur = new Node(node.val);  // copy value
        copiedNodes.put(cur.val, cur);
        // copy adjacency list
        for (Node n: node.neighbors) {
            Node newNode = copyNodes(n, copiedNodes);
            cur.neighbors.add(newNode);
        }
        return cur;

    }
}













