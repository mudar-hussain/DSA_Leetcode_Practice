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
        if(head == null) return head;
        int size = 0;
        ListNode curr = head;
        while(curr!=null) {
            size++;
            curr = curr.next;
        }
        curr = head;
        if(size == n) return head.next;
        size -= n;
        while(--size>0) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return head;

    }
}