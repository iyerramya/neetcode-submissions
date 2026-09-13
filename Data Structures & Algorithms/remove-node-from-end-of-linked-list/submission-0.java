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
        ListNode c = head;
        int len = 0;
        while(c != null) {
            len += 1;
            c = c.next;
        }
        int last = len - n;
        if(last == 0) {
            return head.next;
        }
        c = head; 
        for(int i=0; i<len-1; i++) {
            if((i+1) == last) {
                c.next = c.next.next;
                break;
            }
            c = c.next;
        }        
        return head;

    }
}
