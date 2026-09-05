/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        // Base case: 0 or 1 element is already sorted
        if (head == null || head.next == null) {
            return head;
        }
        
        // Step 1: Split the list into two halves
        ListNode mid = FindMid(head);
        ListNode midNext = mid.next;
        mid.next = null; // Break the bond
        
        // Step 2: Recursively sort each half
        ListNode left = sortList(head);
        ListNode right = sortList(midNext);
        
        // Step 3: Merge the sorted halves
        return merge(left, right);
    }

    // Helper function to find the middle node using slow and fast pointers
    ListNode FindMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = slow.next;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Helper function to merge two sorted linked lists recursively
    ListNode merge(ListNode left, ListNode right) {
        if (left == null) return right;
        if (right == null) return left;
        
        if (left.val < right.val) {
            left.next = merge(left.next, right);
            return left;
        } else {
            right.next = merge(left, right.next);
            return right;
        }
    }
}