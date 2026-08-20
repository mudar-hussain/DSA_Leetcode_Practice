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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = 0;
        ListNode curr = head, prev = null;
        while(curr!=null) {
            len++;
            curr = curr.next;
        }
        curr = head;
        int n = len/k, r = len % k;
        ListNode[] res = new ListNode[k];
        for(int i = 0; i<k && curr!=null; i++,r--) {
            res[i] = curr;
            for(int j = 0; j<n + (r>0?1:0); j++) {
                prev = curr;
                curr = curr.next;
            }
            if(prev!=null) {
                prev.next = null;
            }

        }
        return res;
    }
}