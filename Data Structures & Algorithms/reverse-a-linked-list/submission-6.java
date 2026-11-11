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
        // idea: have 2 pointers, cur and curnext, make curnext point to cur
        if (head == null) return null;
        
        ListNode cur = head;
        ListNode tail = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = tail;
            tail = cur;
            cur = next;
        }
        return tail;
    }
}
