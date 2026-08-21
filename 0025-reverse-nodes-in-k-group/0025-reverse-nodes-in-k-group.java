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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1) return head;
        int len = 0;
        ListNode curr = head;
        while(curr!=null) {
            len++;
            curr = curr.next;
        }
        int groups = len/k;
        ListNode dummy = new ListNode(0,head), prev = dummy, next = null;
        curr = head;
        ListNode currHead = curr, lastTail = dummy;
        while(groups-->0) {
            currHead = curr;
            lastTail = prev;
            for(int i = 0; i<k; i++) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            lastTail.next = prev;
            currHead.next = curr;
            prev = currHead;
        }
        return dummy.next;
        
    }
}