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
    public ListNode middleNode(ListNode head) {
        int n = 0;
        ListNode pt = head;
        while(pt!=null) {
            n++;
            pt = pt.next;
        }
        int middle = n/2;
        pt = head;
        while(middle-->0) pt = pt.next;
        return pt;
    }
}