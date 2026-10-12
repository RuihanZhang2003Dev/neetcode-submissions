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
        /*
        idea: iterate through the lists l1 and l2, add the current value of their nodes up
        be sure to count in the carry over, when we reach the end of one of the list, check if we 
        are done with the other one, if not, go through the other one, do not forget the carry 
        over from the last operation, then just assign the rest
        */

        int carry = 0;
        ListNode head = null;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode cur = head;
        while (cur1 != null && cur2!= null) {
            int tmpRes = cur1.val + cur2.val + carry;
            carry = tmpRes/10;
            ListNode newNode = new ListNode(tmpRes % 10);

            if (head == null) {
                head = newNode;
                cur = head;
            }
            else {
                cur.next = newNode;
                cur = cur.next;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        while (cur1 != null) {
            int tmpRes = cur1.val + carry;
            carry = tmpRes/10;
            ListNode newNode = new ListNode(tmpRes% 10);
            cur.next = newNode;
            cur = cur.next;
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            int tmpRes = cur2.val + carry;
            carry = tmpRes/10;
            ListNode newNode = new ListNode(tmpRes% 10);
            cur.next = newNode;
            cur = cur.next;
            cur2 = cur2.next;
        }

        if (carry > 0) {
            ListNode newNode = new ListNode(1);
            cur.next = newNode;
            cur = cur.next;
        }
        return head;

    }
}
