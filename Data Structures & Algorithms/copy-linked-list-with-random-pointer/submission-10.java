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
    idea: start with a hashmap that maps the original node to the new copy node, then all we have 
    to do to get the copy.random is to find where the original node.random is pointing to, and 
    use it as key to find its copy
    */

    // first, hashmap
    HashMap<Node, Node> map = new HashMap<>();
    Node cur = head;
    while (cur != null) {
        Node copy = new Node(cur.val);
        map.put(cur, copy);
        cur= cur.next;
    }

    // second, find next and random and point them to it
    cur = head;
    while (cur != null) {
        map.get(cur).next = map.get(cur.next);
        map.get(cur).random = map.get(cur.random);
        cur = cur.next;
    }
    return map.get(head);


    }
}
