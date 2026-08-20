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
    private ListNode reverse(ListNode head, int count) {
        ListNode prev = null, curr = head, next = null;
        while(curr!=null && count-->0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head.next = curr;
        return prev;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null || left == right) return head;
        ListNode dummy = new ListNode(0, head), prev = dummy;
        for(int i = 1; i<left; i++) {
            prev = prev.next;
        }
        prev.next = reverse(prev.next, right-left+1);
        return dummy.next;
        
    }
}