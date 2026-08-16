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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        int n = 1;
        ListNode curr = head;
        while(curr.next != null) {
            n++;
            curr = curr.next;
        }
        k = k%n;
        if(k==0) return head;
        n -= k;
        curr.next = head;
        curr = head;
        while(--n>0) {
            curr = curr.next;
        }
        head = curr.next;
        curr.next = null;
        return head;
        
    }
}