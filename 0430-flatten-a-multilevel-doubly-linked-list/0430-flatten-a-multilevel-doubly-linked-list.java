/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        dfs(head);
        return head;
        
    }
    private Node dfs(Node head) {
        if(head == null || (head.next == null && head.child == null)) return head;
        Node nextTail = dfs(head.next);
        Node childTail = dfs(head.child);
        if(childTail != null) {
            if(head.next!=null) {
                childTail.next = head.next;
                head.next.prev = childTail;
            }
            
            head.next = head.child;
            head.child.prev = head;
            head.child = null;
        }
        return nextTail!=null ? nextTail : childTail;
    }
}