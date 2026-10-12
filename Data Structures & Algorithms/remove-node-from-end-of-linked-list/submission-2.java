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
        /*
        idea: iterate through the node and find the length, then iterate through it one more time
        to remove the node by locating it to length -n
        */
        ListNode cur = head;
        // get the count
        int length = 0;
        while (cur != null) {
            length++;
            cur= cur.next;
        }
        
        ListNode prev = null;
        cur = head;
        int target = length -n;
        int index = 0;
        while (index < target) {
            prev = cur;
            cur = cur.next;
            index++;
        }

        // check if prev is null, that means if we are removing the first element or not
        if (prev == null) head = head.next; 
        else prev.next = cur.next;      
        cur.next = null;
        
        return head;
    }
}
