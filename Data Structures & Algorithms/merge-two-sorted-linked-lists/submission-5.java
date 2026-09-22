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
        /*
        idea: advance whichever head's value is lower, and put it into the list,
        if equal, use list1 first, then list 2
        */

        
        if (list1 == null) {
            if (list2 == null) return null;
            else return list2;
        }
        if (list2 == null) {
            if (list1 == null) return null;
            else return list1;
        }
        ListNode head = new ListNode();
        if (list1.val < list2.val){
            head = list1;
            list1 = list1.next;
        }
        else {
            head = list2;
            list2 = list2.next;
        }
        ListNode cur = head;
        while (list1 != null && list2 != null){
            if (list1.val < list2.val){
                ListNode tmp1 = list1.next;
                cur.next = list1;
                cur = cur.next;
                list1 = tmp1;
            }
            else {
                ListNode tmp2 = list2.next;
                cur.next = list2;
                cur = cur.next;
                list2 = tmp2;
            }
        }
    
        if (list1 != null) {
            cur.next = list1;
        }
        else cur.next = list2;
        return head;
        
    }
}