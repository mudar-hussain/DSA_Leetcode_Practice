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
    public int pairSum(ListNode head) {

        ListNode curr = head;
        int n = 0;
        while(curr!=null) {
            n++;
            curr = curr.next;
        }
        int maxSum = -1;
        Stack<Integer> st = new Stack<>();
        curr= head;
        while(curr!=null) {
            if(st.size()<n/2 && maxSum == -1) {
                st.push(curr.val);
            } else {
                maxSum = Math.max(maxSum, curr.val+st.pop());
            }
            curr = curr.next;
        }
        return maxSum;
    }
}