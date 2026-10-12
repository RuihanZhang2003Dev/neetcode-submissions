/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        /*
        idea: 2 passes, first step: create a hashmap, map the old one to the deep copy, then
        link the new nodes by extracting them with the old nodes.
        */

        // first use a hashmap
        HashMap<Node, Node> map = new HashMap<>();

        Node cur = head;
        while (cur != null) {
            Node copy = new Node(cur.val);
            map.put(cur, copy);
            cur = cur.next;
        }

        // second pass: link the new nodes with the info for the old ones
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
        

    }
}
