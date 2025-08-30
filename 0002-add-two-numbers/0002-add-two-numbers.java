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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode();
        int carryForward = 0;
        ListNode prev = ans;
        while(l1 != null || l2 != null){
            int sum = (l1!=null?l1.val:0) + (l2!=null?l2.val:0) + carryForward;
            carryForward = sum/10;
            sum = sum%10;
            ListNode node = new ListNode(sum);
            prev.next = node;
            prev = node;
            l1 = l1!=null?l1.next:l1;
            l2 = l2!=null?l2.next:l2;
        }
        if (carryForward > 0) {
            ListNode node = new ListNode(carryForward);
            prev.next = node;
        }
        return ans.next;
    }
}