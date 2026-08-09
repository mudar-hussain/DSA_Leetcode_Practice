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
    public int getDecimalValue(ListNode head) {
        int n = -1;
        ListNode pt = head;
        while(pt!=null) {
            n++;
            pt = pt.next;
        }
        int res = 0;
        while(head!=null) {
            if(head.val != 0) {
                res += Math.pow(2, n) * head.val;
            }
            n--;
            head = head.next;
        }
        return res;

    }
}