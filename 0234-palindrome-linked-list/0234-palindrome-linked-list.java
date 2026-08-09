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
    public boolean isPalindrome(ListNode head) {
        ListNode pt = head;
        int n = 0;
        while(pt!=null) {
            n++;
            pt = pt.next;
        }
        boolean isOdd = n%2!=0;
        n = n/2;
        int[] seq = new int[n+1];
        for(int i = 1; i<=n; i++) {
            seq[i] = head.val;
            head = head.next;
        }
        if(isOdd) head = head.next;
        while(head!=null) {
            if(seq[n--] != head.val) return false;
            head = head.next;
        }
        return true;
    }
}