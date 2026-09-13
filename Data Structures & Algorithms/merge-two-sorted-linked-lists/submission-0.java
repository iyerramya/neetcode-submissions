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
        ListNode t3 = new ListNode(0);
        ListNode res = t3;
        while(list1 != null && list2 != null) {
            ListNode t1 = list1.next;
            ListNode t2 = list2.next;
            if(list1.val < list2.val) {
                res.next = list1;
                res = res.next;
                list1 = t1;
            } else {
                res.next = list2;
                res = res.next;
                list2 = t2;
            } 
        }
        if(list1 != null) {
            res.next = list1;
        }
        if(list2 != null) {
            res.next = list2;
        }
        return t3.next;
    }
}