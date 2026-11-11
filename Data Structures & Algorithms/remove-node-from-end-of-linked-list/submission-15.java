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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // find the length and the index we should remove
        
        
        int len = 0;
        ListNode cur = head;
        
        while (cur != null) {
            cur = cur.next;
            len++;
        }
        if (len == 1) return null;
        cur = new ListNode();
        ListNode newHead = cur;
        cur.next = head;
        int index = 0;
        int remove = len - n;
        while (cur != null) {
            if (index == remove){
                cur.next = cur.next.next;
                cur = cur.next;
                index++;
            } 
            else {
                cur = cur.next;
                index++;
            }
        }
        return newHead.next;
    }
}
