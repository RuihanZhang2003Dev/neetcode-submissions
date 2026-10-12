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
    public void reorderList(ListNode head) {
        /*
        idea: find the middle of the linkedlist, cut it in half, revert the 
        lower half, then merge them alternatively.
        */
        // 1. find the middle fo the list, then cut it in half.
        if (head == null) return;

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode cur1 = head;
        ListNode cur2 = slow.next;
        slow.next = null;
        
        // 2. revert the bottom half
        ListNode head2 = null;
        while (cur2 != null) {
            ListNode tmp = cur2;
            cur2 = cur2.next;
            tmp.next = head2;
            head2 = tmp;
        }
        cur2 = head2;
        // 3. merge
        while (cur1 != null && cur2 != null) {
            ListNode tmp1 = cur1.next;
            ListNode tmp2 = cur2.next;
            cur1.next = cur2;
            cur2.next = tmp1;
            cur1 = tmp1;
            cur2 = tmp2;
        }

    }
}
