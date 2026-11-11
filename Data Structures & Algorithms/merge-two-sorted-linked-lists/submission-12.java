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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // make a dummy node and detache them
        ListNode dummy = new ListNode();
        ListNode head = dummy;
        ListNode cur1 = list1;
        ListNode cur2 = list2;

        while (cur1 != null & cur2 != null) {
            if (cur1.val < cur2.val) {
                head.next = cur1;
                cur1 = cur1.next;
                head = head.next;
            }
            else {
                head.next = cur2;
                cur2 = cur2.next;
                head =head.next;
            }
        }
        if (cur1 != null) head.next = cur1;
        if (cur2 != null) head.next = cur2;
        return dummy.next;
    }
}