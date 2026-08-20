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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        else if(lists.length == 1) return lists[0];
        ListNode dummy = new ListNode(0), curr = dummy;
        while(curr!=null) {
            int mini = 0;
            for(int i = 1; i<lists.length; i++) {
                if(lists[mini] == null) mini = i;
                else if(lists[i]!=null && lists[mini].val > lists[i].val) {
                    mini = i;
                }
            }
            curr.next = lists[mini];
            curr = curr.next;
            if(lists[mini] != null) lists[mini] = lists[mini].next;
        }
        return dummy.next;

        
    }
}