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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pt = head;
        while(pt!=null && pt.next != null) {
            if(pt.val == pt.next.val) {
                pt.next = pt.next.next;
            } else {
                pt = pt.next;
            }
        }
        return head;
    }
}