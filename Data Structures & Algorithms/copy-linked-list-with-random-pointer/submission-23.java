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
        // better answer, insert copy node in the list, and copy next and random in place, the copied
        // node will be right after the original node, then separate
        if (head == null) return null;
        Node cur = head;
        while (cur != null) {
            Node newN = new Node(cur.val);
            newN.next = cur.next;
            cur.next = newN;
            cur = cur.next.next;  
        }
        cur = head;
        // get random pointer
        while (cur != null) {
            if (cur.random != null) cur.next.random = cur.random.next;
            cur = cur.next.next;
        }

        // separate
        cur = head;
        Node copyHead = head.next;
        while (cur!= null) {
            Node copy = cur.next;
            cur.next = copy.next;
            
            if (copy.next != null) copy.next = copy.next.next;
            cur = cur.next;
        }
        return copyHead;

    }
}
