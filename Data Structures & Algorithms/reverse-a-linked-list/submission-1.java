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
    public ListNode reverseList(ListNode head) {
        /*
        idea: get the head, put it in tail, the next node will be the previous node of head,
        update the new head, adjust the node 
        */

        

        ListNode newHead = head;
        if (newHead == null ||newHead.next == null) return newHead;
        head = head.next;
        newHead.next = null;

        while (head.next != null) {
            ListNode cur = head;
            head = head.next;
            cur.next = newHead;
            newHead = cur;
        }
        ListNode cur = head;
        cur.next = newHead;
        newHead = cur;
        

        return newHead;



    }
}
