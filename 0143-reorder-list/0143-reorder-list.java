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
    private ListNode findMid(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode reverse(ListNode curr) {
        ListNode prev = null, next = null;
        while(curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    private void merge(ListNode l1, ListNode l2) {
        ListNode curr = l1;
        l1 = l1.next;
        while(l1 != null && l2 != null) {
            curr.next = l2;
            l2 = l2.next;
            curr = curr.next;
            curr.next = l1;
            l1 = l1.next;
            curr = curr.next;
        }
        if(l1!=null) {
            curr.next = l1;
        }
        if(l2 != null) {
            curr.next = l2;
        }
    }
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode l1 = head, mid = findMid(head);
        ListNode l2 = reverse(mid.next);
        mid.next = null;
        merge(l1, l2);
    }
}