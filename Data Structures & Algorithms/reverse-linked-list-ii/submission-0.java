/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // idea: make a dummy tail and add left to the front of the tail, after all that, add the
        // reversed list back to the linkedlist

        ListNode dumHead = new ListNode();
        ListNode cur = dumHead;
        ListNode firstseg = dumHead;
        ListNode dumTail = new ListNode();
        ListNode secondseg = null;
        dumHead.next = head;

        int ind = 0;
        while (ind <= right) {
            if (ind < left) {
                firstseg = cur;
                cur = cur.next;
                ind++;
            }
            else {
                // put the current in front of tail, move tail up,
                ListNode next = cur.next;
                cur.next = dumTail;
                dumTail = cur;
                if (secondseg == null) secondseg = dumTail;
                cur = next;
                ind++;
            }
        }
        // link first seg mid seg and second seg together
        secondseg.next = cur;
        firstseg.next = dumTail;
        return dumHead.next;
    }
}