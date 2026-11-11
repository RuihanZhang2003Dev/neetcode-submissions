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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // idea: iterate through the list, check for carry, the question did everything for us
        // the nodes are already in order of calculation (from unit to tenth then to hundredth)
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        int carry = 0;

        // l1 and l2 assumed to be the same len
        while (cur1 != null && cur2 != null) {
            int sum = cur1.val + cur2.val + carry;
            carry = sum/10;
            ListNode sumNode = new ListNode(sum % 10);
            cur.next = sumNode;
            cur = cur.next;
            cur1= cur1.next;
            cur2= cur2.next;
        }
        while (cur1 != null) {
            int sum = cur1.val + carry;
            carry = sum/10;
            ListNode sumNode = new ListNode(sum % 10);
            cur.next = sumNode;
            cur = cur.next;
            cur1= cur1.next;
        }
        while (cur2 != null) {
            int sum = cur2.val + carry;
            carry = sum/10;
            ListNode sumNode = new ListNode(sum % 10);
            cur.next = sumNode;
            cur = cur.next;
            cur2= cur2.next;
        }
        if (carry == 1) cur.next = new ListNode(1);
        return dummy.next;
    }
}
