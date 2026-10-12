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
        idea: add a copy of the node right after the node, then remove the original list later
        */

        if (head == null) {
            return null;
        }

        // first, add a copy of the node right after the node
        Node cur = head;
        while (cur != null) {
            Node copy = new Node(cur.val);
            copy.next = cur.next;
            cur.next = copy;
            cur = copy.next;
        }

        // then, assign random
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        // finally, separate the list
        cur = head;
        Node copyHead = head.next;
        while (cur != null) {
            Node copy = cur.next;
            cur.next = copy.next;
            if (copy.next != null) {
                copy.next = copy.next.next;
            }
            cur = cur.next;
        }
        return copyHead;
    }
}
