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
        idea: separate the tree in half, revert the second half and merge them
        */
        ListNode cur = head;
        int len = 0;

        // get length to cut in half
        while (cur != null) {
            cur = cur.next;
            len++;
        }

        cur = head;
        ListNode cur2 = head;
        int index = 0;
        // include since the initial list must have the most element
        while (index < (len)/2) {
            cur = cur.next;
            cur2 = cur2.next;
            index++;
        }
        // cur2 will be the head of the second list
        cur2 = cur2.next;
        cur.next = null;
        cur = head;

        // revert
        ListNode tail = null;
        while (cur2 != null) {
            ListNode next =cur2.next;
            cur2.next = tail;
            tail = cur2;
            cur2 = next;
        }
        cur2 = tail;
        // merge
        while (cur2 != null) {
            ListNode next = cur.next;
            cur.next = cur2;
            cur2 = cur2.next;
            cur.next.next = next;
            cur = next;
        }
        
    }
}
