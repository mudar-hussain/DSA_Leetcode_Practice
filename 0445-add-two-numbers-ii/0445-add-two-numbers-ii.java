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
    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head, next = head.next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1.next==null && l1.val == 0) return l2;
        if(l2.next==null && l2.val == 0) return l1;
        l1 = reverse(l1);
        l2 = reverse(l2);
        int carryOver = 0;
        ListNode res = new ListNode(0), curr = res;

        while(l1!=null || l2!=null) {
            int sum = 0;
            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            };
            sum += carryOver;
            curr.next = new ListNode(sum%10);
            carryOver = sum/10;
            curr = curr.next;
        }
        while(carryOver > 0) {
            curr.next = new ListNode(carryOver%10);
            carryOver /= 10;
        }
        return reverse(res.next);
    }
}