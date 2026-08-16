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
    int N = 0;
    ListNode head = null;
    public Solution(ListNode head) {
        this.head = head;
        while (head != null) {
            this.N ++;
            head = head.next;
        }
    }
    
    public int getRandom() {
        int i = (int)(Math.random() * this.N);
        ListNode p = this.head;
        while (i > 0) { 
            p = p.next;
            i -= 1;
        }
        return p.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */